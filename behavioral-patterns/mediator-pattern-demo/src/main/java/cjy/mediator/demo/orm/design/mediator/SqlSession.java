package cjy.mediator.demo.orm.design.mediator;

import java.util.List;

/**
 * 数据库操作接口
 */
public interface SqlSession {

    <T> T selectOne(String statement);

    <T> T selectOne(String statement, Object parameter);

    <T> List<T> selectList(String statement);

    <T> List<T> selectList(String statement, Object parameter);

    void close();

}
