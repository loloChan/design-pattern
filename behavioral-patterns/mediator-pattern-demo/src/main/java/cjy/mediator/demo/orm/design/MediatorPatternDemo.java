package cjy.mediator.demo.orm.design;

import cjy.mediator.demo.orm.design.mediator.DefaultSqlSessionFactory;
import cjy.mediator.demo.orm.design.mediator.SqlSession;
import cjy.mediator.demo.orm.design.mediator.SqlSessionFactoryBuilder;
import cjy.mediator.demo.orm.vo.User;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MediatorPatternDemo {

    private static Logger logger = LoggerFactory.getLogger(MediatorPatternDemo.class);

    public static void main(String[] args) throws Exception {

        DefaultSqlSessionFactory sqlSessionFactory = SqlSessionFactoryBuilder.build("mybatis-config.xml");
        SqlSession sqlSession = sqlSessionFactory.openSqlSession();
        Integer id = 1;
        User user = sqlSession.selectOne("cjy.mediator.demo.orm.design.dao.UserDao.findUserById", id);

        logger.info("selectOne test result: {}", JSON.toJSONString(user));

        List<User> list = sqlSession.selectList("cjy.mediator.demo.orm.design.dao.UserDao.findAllUser");
        logger.info("selectList test result: {}", JSON.toJSONString(list));

        sqlSession.close();
    }
}
