package cjy.iterator.demo.util;

import cjy.iterator.demo.vo.Employee;
import cjy.iterator.demo.vo.Link;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * 组织树集合具体实现,线程不安全
 */
public class GroupStructure implements Collection<Employee, Link> {

    /**
     * 日志对象
     */
    private static Logger logger = LoggerFactory.getLogger(GroupStructure.class);

    /**
     * 组织id
     */
    private Long groupId;

    /**
     * 名称
     */
    private String groupName;

    /**
     * 用于存放userid/节点id 与 employee元素之间的映射关系, id -> employee
     */
    private Map<Long, Employee> employeeMap = new HashMap<>();

    /**
     * 节点与链接节点的映射关系 , id -> List<childId>
     */
    private Map<Long, List<Link>> linksMap = new HashMap<>();

    /**
     * 反向关系链，childId -> parentId
     */
    private Map<Long, Long> invertedMap = new HashMap<>();

    /**
     * 组织树根节点
     */
    private Employee root;

    public GroupStructure(Long groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;

        //初始化一个根节点
        Employee root = new Employee();
        root.setName(groupName);
        root.setUserId(groupId);

        employeeMap.put(groupId, root);
        this.root = root;
    }

    /**
     * 添加元素
     *
     * @param employee
     * @return
     */
    @Override

    public boolean add(Employee employee) {
        Long id = employee.getUserId();

        if (employeeMap.containsKey(id)) {
            //将原有的linksMap关联清除
            Employee old = employeeMap.get(id);
            Long oldParentId = old.getParentId();
            List<Link> links = linksMap.get(oldParentId);
            if (null != links) {
                Optional<Link> any = links.stream().filter(link -> {
                    return link.getChildId() == id;
                }).findAny();
                if (any.isPresent()) {
                    links.remove(any.get());
                }
            }
        }
        //判断parentId的合法性,父节点必须存在
        Long parentId = employee.getParentId();
        if (!employeeMap.containsKey(parentId)) {
            logger.error("parent node is not exist ! parentId = {}", parentId);
            return false;
        }
        employeeMap.put(id, employee);

        //更新linksMap
        List<Link> links = linksMap.get(parentId);
        if (null == links) {
            links = new ArrayList<>();
        }
        Link link = new Link();
        link.setChildId(id);
        link.setParentId(parentId);

        links.add(link);

        if (!linksMap.containsKey(parentId)) {
            linksMap.put(parentId, links);
        }

        //更新invertedMap
        if (invertedMap.containsKey(id)) {
            //若原系统中已存在该employee，重复存入可能会更改某些信息，例如parentId
            //所以清空再重新存入新的关系
            invertedMap.remove(id);
        }
        invertedMap.put(id,parentId);
        return true;
    }

    /**
     * 根据员工id获取元素
     *
     * @param id 员工id
     * @return
     */
    @Override
    public Employee get(Long id) {
        return employeeMap.get(id);
    }

    /**
     * 删除集合元素
     *
     * @param employee
     * @return
     */
    @Override
    public boolean remove(Employee employee) {

        Long id = employee.getUserId();
        //更新employeeMap
        if (employeeMap.containsKey(id)) {
            employee = employeeMap.remove(id);
        }

        //更新 linksMap
        Long parentId = employee.getParentId();
        if (linksMap.containsKey(parentId)) {
            List<Link> links = linksMap.get(parentId);
            Optional<Link> any = links.stream()
                    .filter(link -> {
                        return link.getChildId() == id;
                    })
                    .findAny();
            if (any.isPresent()) {
                links.remove(any.get());
            }
        }

        //更新invertedMap
        if (invertedMap.containsKey(id)) {
            invertedMap.remove(id);
        }

        return true;
    }

    /**
     * 获取该集合的迭代器
     *
     * @return {@link Iterator}
     */
    @Override
    public Iterator<Employee> iterator() {
        return new Itr();
    }

    /**
     * 内部类，实现迭代器接口
     */
    private class Itr implements Iterator<Employee> {

        /**
         * 记录节点宽度遍历进度。
         * key ： 节点id
         * value ： 遍历到key节点的哪个子节点id
         */
        private Map<Long, Integer> keyMap = new HashMap<>();

        private Long parentId = groupId;
        private Long currentId = groupId;

        private int total = 0;

        /**
         * 判断集合中是否还有未被访问的元素
         *
         * @return
         */
        @Override
        public boolean hasNext() {
            return total < employeeMap.size() - 1;
        }

        /**
         * 获取下一个元素
         *
         * @return
         */
        @Override
        public Employee next() {

            //获取当前节点的子节点集
            List<Link> links = linksMap.get(currentId);
            //获取当前子节点遍历指针
            int cursor = getCursor(currentId);

            //当前节点是叶子节点，返回父节点的子节点集
            if (null == links) {
                links = linksMap.get(parentId);
                cursor = getCursor(parentId);
            }

            // 若当前节点的子节点集已遍历完毕，继续往上找父节点的子节点集
            while (cursor > links.size() - 1) {
                parentId = invertedMap.get(parentId);
                cursor = getCursor(parentId);
                links = linksMap.get(parentId);
            }

            Link link = links.get(cursor);
            currentId = link.getChildId();
            parentId = link.getParentId();
            Employee employee = employeeMap.get(currentId);

            total++;

            return employee;
        }

        /**
         * 获取宽度遍历子节点的下标
         * @param id
         * @return
         */
        private int getCursor(Long id) {

            int idx = 0;

            if (keyMap.containsKey(id)) {
                idx = keyMap.get(id);
                keyMap.put(id, idx + 1);
            } else {
                keyMap.put(id, idx + 1);
            }

            return idx;

        }
    }

    /**
     * 打印树信息，用于验证
     */
    public void print() {
        logger.info("employeeMap: {}",JSON.toJSONString(employeeMap));
        logger.info("linksMap: {}",JSON.toJSONString(linksMap));
        logger.info("invertedMap: {}",JSON.toJSONString(invertedMap));
    }

}
