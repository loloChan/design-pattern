package cjy.proxy.demo.test;

import cjy.proxy.demo.dao.UserDao;
import cjy.proxy.demo.factory.MapperProxyFactory;
import cjy.proxy.demo.vo.SqlSession;
import org.junit.Test;

public class ProxyTest {

    @Test
    public void mapperTest() {

        MapperProxyFactory<UserDao> mapperProxyFactory = new MapperProxyFactory();
        SqlSession sqlSession = new SqlSession();

        UserDao mapper = mapperProxyFactory.getMapper(UserDao.class, sqlSession);
        String result = mapper.findByUserId("10001");

        System.out.println("查询结果为：" + result);

    }

}
