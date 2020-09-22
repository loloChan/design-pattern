package cjy.iterator.demo.util;

/**
 * 迭代器接口
 */
public interface Iterator<E> {

    /**
     * 判断集合中是否还有未被访问的元素
     * @return
     */
    boolean hasNext();

    /**
     * 获取下一个元素
     * @return
     */
    E next();

}
