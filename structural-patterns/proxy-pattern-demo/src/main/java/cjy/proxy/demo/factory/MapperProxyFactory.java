package cjy.proxy.demo.factory;

import cjy.proxy.demo.proxy.MapperProxy;
import cjy.proxy.demo.vo.SqlSession;

import java.lang.reflect.Proxy;

/**
 * Mapper代理工厂类。
 * @param <T>
 */
public class MapperProxyFactory<T> {

    /**
     * 获取映射代理类
     * @param type mapper接口
     * @param sqlSession 模拟mybatis的sqlsession
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        if (null == loader) {
            loader = this.getClass().getClassLoader();
        }

        return (T)Proxy.newProxyInstance(loader,new Class[]{type},new MapperProxy(sqlSession));

    }

}
