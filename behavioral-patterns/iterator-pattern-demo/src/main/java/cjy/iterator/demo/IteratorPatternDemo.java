package cjy.iterator.demo;

import cjy.iterator.demo.util.GroupStructure;
import cjy.iterator.demo.util.Iterator;
import cjy.iterator.demo.vo.Employee;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IteratorPatternDemo {

    private static Logger logger = LoggerFactory.getLogger(IteratorPatternDemo.class);

    public static void main(String[] args) {

        GroupStructure groupStructure = new GroupStructure(0L, "公司组织树");

        Employee ceo = new Employee(1L,"小红",0L,"总裁");
        Employee employee1 = new Employee(2L,"小红",1L,"X经理");
        Employee employee2 = new Employee(3L,"大华",1L,"J经理");
        Employee employee3 = new Employee(4L,"喔喔",1L,"Y经理");
        Employee employee4 = new Employee(5L,"蜗蜗",2L,"手下");
        Employee employee5 = new Employee(6L,"拉拉",2L,"手下");
        Employee employee6 = new Employee(7L,"盘盘",3L,"手下");

        groupStructure.add(ceo);
        groupStructure.add(employee1);
        groupStructure.add(employee2);
        groupStructure.add(employee3);
        groupStructure.add(employee4);
        groupStructure.add(employee5);
        groupStructure.add(employee6);

        Iterator<Employee> iterator = groupStructure.iterator();

        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            logger.info(JSON.toJSONString(employee));
        }

    }

}
