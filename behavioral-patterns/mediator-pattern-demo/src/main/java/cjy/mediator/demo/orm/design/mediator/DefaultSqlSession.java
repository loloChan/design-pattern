package cjy.mediator.demo.orm.design.mediator;

import cjy.mediator.demo.orm.vo.XNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * SqlSession默认实现
 */
public class DefaultSqlSession implements SqlSession {

    /**
     * 日志对象
     */
    private static Logger logger = LoggerFactory.getLogger(DefaultSqlSession.class);

    private Connection connection;

    /**
     * namespace.id -> <mapper/> 映射
     */
    private Map<String, XNode> mapperElement;

    public DefaultSqlSession(Connection connection, Map<String, XNode> mapperElement) {
        this.connection = connection;
        this.mapperElement = mapperElement;
    }

    @Override
    public <T> T selectOne(String statement) {
        List<T> list = selectList(statement);
        if (null != list) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        List<T> list = selectList(statement, parameter);
        if (null != list) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public <T> List<T> selectList(String statement) {
        try {
            //获取配置的mapper节点
            XNode xNode = mapperElement.get(statement);
            PreparedStatement preparedStatement = connection.prepareStatement(xNode.getSql());
            ResultSet resultSet = preparedStatement.executeQuery();
            Class<T> resultType = (Class<T>) Class.forName(xNode.getResultType());
            List<T> results = resultSet2List(resultSet, resultType);
            return results;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public <T> List<T> selectList(String statement, Object parameter) {
        try {
            XNode xNode = mapperElement.get(statement);
            PreparedStatement preparedStatement = connection.prepareStatement(xNode.getSql());
            buildParameter(preparedStatement, parameter, xNode.getParameter());
            ResultSet resultSet = preparedStatement.executeQuery();
            Class<T> resultType = (Class<T>) Class.forName(xNode.getResultType());
            List<T> results = resultSet2List(resultSet,resultType);
            return results;
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return null;
    }

    /**
     * 关闭connection连接
     */
    @Override
    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
    }

    /**
     * 结果集封装
     * @param resultSet 数据库结果集
     * @param resultType 返回值类型
     * @param <T>
     * @return
     */
    private <T> List<T> resultSet2List(ResultSet resultSet, Class<T> resultType) {

        List<T> resultList = new ArrayList<>();

        try {
            //定义的成员变量名
            Field[] fields = resultType.getDeclaredFields();

            //遍历行
            while (resultSet.next()) {
                T result = resultType.newInstance();
                for (Field field : fields) {

                    String fieldName = field.getName();
                    String columnName = fieldName.toLowerCase();
                    Object value = resultSet.getObject(columnName);
                    if (null == value) {
                        continue;
                    }
                    //获取set方法
                    Method method;
                    String setMethodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

                    //判断value的类型
                    if (value instanceof Timestamp) {
                        method = resultType.getMethod(setMethodName, Date.class);
                    } else {
                        method = resultType.getMethod(setMethodName, value.getClass());
                    }
                    method.invoke(result, value);
                }

                resultList.add(result);

            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return resultList;
    }

    private void buildParameter(PreparedStatement pstmt, Object parameter, Map<Integer, String> parameterMap) throws Exception {

        int size = parameterMap.size();

        //只有单个参数
        if (1 == size) {
            if (parameter instanceof Long) {
                pstmt.setLong(1,Long.parseLong(parameter.toString()));
                return;
            } else if (parameter instanceof Integer) {
                pstmt.setInt(1, Integer.parseInt(parameter.toString()));
                return;
            } else if (parameter instanceof String) {
                pstmt.setString(1, parameter.toString());
                return;
            } else if (parameter instanceof Date) {
                pstmt.setDate(1, (java.sql.Date) parameter);
            }
        }

        //parameter是一个vo
        Map<String, Object> fieldMap = new HashMap<>();
        //对象参数
        Field[] fields = parameter.getClass().getDeclaredFields();
        //获取对象参数值
        for (Field field : fields) {
            String fieldName = field.getName();
            field.setAccessible(true);
            Object value = field.get(parameter);
            field.setAccessible(false);
            fieldMap.put(fieldName, value);
        }

        for (int i = 1; i <= size; i++) {

            String columnName = parameterMap.get(i);
            //对应参数的值
            Object value = fieldMap.get(columnName);

            //类型判断
            if (value instanceof Short) {
                pstmt.setShort(i, Short.parseShort(value.toString()));
            } else if (value instanceof Integer) {
                pstmt.setInt(i, Integer.parseInt(value.toString()));
            } else if (value instanceof Long) {
                pstmt.setLong(i, Long.parseLong(value.toString()));
            } else if (value instanceof String) {
                pstmt.setString(i, value.toString());
            } else if (value instanceof Date) {
                pstmt.setDate(i, (java.sql.Date) value);
            } else {
                throw new IllegalArgumentException("不支持该参数类型:" + value.getClass());
            }
        }

    }
}
