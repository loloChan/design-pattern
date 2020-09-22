package cjy.iterator.demo.util;

/**
 * 组织树集合功能接口定义
 */
public interface Collection<E, L> extends Iterable<E> {

    /**
     * 添加元素
     * @param e
     * @return
     */
    boolean add(E e);

    /**
     * 根据员工id获取元素
     * @param id 员工id
     * @return
     */
    E get(Long id);

    /**
     * 删除集合元素
     * @param e
     * @return
     */
    boolean remove(E e);

    /**
     * 获取该集合的迭代器
     * @return {@link Iterator}
     */
    Iterator<E> iterator();
}
