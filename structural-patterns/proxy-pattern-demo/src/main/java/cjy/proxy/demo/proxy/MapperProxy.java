package cjy.proxy.demo.proxy;

import cjy.proxy.demo.annotation.Select;
import cjy.proxy.demo.vo.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MapperProxy implements InvocationHandler {

    private static Logger logger = LoggerFactory.getLogger(MapperProxy.class);

    private SqlSession sqlSession;

    public MapperProxy(SqlSession session) {
        this.sqlSession = session;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(proxy, args);
        }

        //获取注解
        Select selectAnnotation = method.getAnnotation(Select.class);
        String sql = selectAnnotation.value();

        //参数处理
        sql = sql.replace("#{userId}", args[0].toString());
        logger.info("sql execute:{}", sql);

        //返回结果
        String result = sqlSession.selectOne(sql);

        return result;
    }
}
