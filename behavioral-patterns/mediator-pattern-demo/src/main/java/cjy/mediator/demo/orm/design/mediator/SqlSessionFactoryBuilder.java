package cjy.mediator.demo.orm.design.mediator;

import cjy.mediator.demo.orm.vo.XNode;
import org.apache.ibatis.builder.xml.XMLMapperEntityResolver;
import org.apache.ibatis.io.Resources;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 工厂建造类。
 * 用于SqlSessionFactory的初始化，包括配置文件的解析等操作
 */
public class SqlSessionFactoryBuilder {

    /**
     * 日志对象
     */
    private static Logger logger = LoggerFactory.getLogger(SqlSessionFactoryBuilder.class);

    /**
     * 提供一个静态访问方法
     * @param path
     * @return
     */
    public static DefaultSqlSessionFactory build(String path) throws Exception{
        Reader reader = Resources.getResourceAsReader(path);
        DefaultSqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        reader.close();
        return sqlSessionFactory;
    }

    /**
     * 获取DefaultSqlSessionFactory
     * @param reader 数据源配置文件io流
     * @return
     */
    public DefaultSqlSessionFactory build(Reader reader) {
        try {
            SAXReader saxReader = new SAXReader();
            //mybatis xml文件解释器
            saxReader.setEntityResolver(new XMLMapperEntityResolver());
            //解析
            Document document = saxReader.read(reader);
            //解析跟节点
            Configuration configuration = parseConfiguration(document.getRootElement());
            return new DefaultSqlSessionFactory(configuration);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return null;
    }

    /**
     * 解析配置文件
     * @param root
     * @return
     */
    private Configuration parseConfiguration(Element root) {

        Configuration configuration = new Configuration();

        configuration.setDataSource(getDataSource(root.selectNodes("//dataSource")));

        configuration.setConnection(getConnection(configuration.getDataSource()));

        configuration.setMapperElement(getMapperElement(root.selectNodes("mappers")));

        return configuration;

    }

    /**
     * 获取数据源配置信息
     * @param list
     * @return
     */
    private Map<String, String> getDataSource(List<Element> list) {
        /*
            <dataSource type="POOLED">
                 <property name="driver" value="com.mysql.jdbc.Driver"/>
                 <property name="url"
                        value="jdbc:mysql://127.0.0.1:3306/itstack_demo_design?useUnicode=true"/>
                 <property name="username" value="root"/>
                 <property name="password" value="123456"/>
            </dataSource>
        */
        Map<String, String> dataSource = new HashMap<>();
        //<dataSource></dataSource>
        Element element = list.get(0);
        //<dataSource>标签的下级标签
        List content = element.content();
        for (Object o : content) {
            Element e = (Element) o;
            String name = e.attributeValue("name");
            String value = e.attributeValue("value");
            dataSource.put(name, value);
        }
        return dataSource;
    }

    /**
     * 根据配置的数据源获取连接
     * @param dataSource
     * @return
     */
    private Connection getConnection(Map<String, String> dataSource) {
        try {
            //加载驱动
            Class.forName(dataSource.get("driver"));
            //获取连接
            String url = dataSource.get("url");
            String password = dataSource.get("password");
            String user = dataSource.get("username");
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 解析<mappers></mappers>标签
     * @param list
     * @return
     */
    private Map<String, XNode> getMapperElement(List<Element> list) {

        Map<String, XNode> mapperElement = new HashMap<>();
        /*
        <mappers>
             <mapper resource="mapper/User_Mapper.xml"/>
             <mapper resource="mapper/School_Mapper.xml"/>
        </mappers>
        */
        //获取<mappers></mappers>标签
        Element element = list.get(0);
        List content = element.content();
        for (Object o : content) {
            //<mapper></mapper>标签
            Element e = (Element) o;
            //mapper.xml文件路径
            String resource = e.attributeValue("resource");

            Reader reader = null;
            //解析mapper.xml文件
            try {
                reader = Resources.getResourceAsReader(resource);
                SAXReader saxReader = new SAXReader();
                Document document = saxReader.read(reader);
                /*
                <mapper namespace="org.itstack.demo.design.dao.IUserDao">
                     <select id="queryUserInfoById" parameterType="java.lang.Long"
                                    resultType="org.itstack.demo.design.po.User">
                                            SELECT id, name, age, createTime, updateTime
                                    FROM user
                                    where id = #{id}
                     </select>
                </mapper>
                */
                //获取根节点
                Element root = document.getRootElement();
                //namespace
                String namespace = root.attributeValue("namespace");
                //<select></select>
                List selectNodes = root.selectNodes("select");
                for (Object selectNode : selectNodes) {
                    Element select = (Element) selectNode;

                    String id = select.attributeValue("id");
                    String parameterType = select.attributeValue("parameterType");
                    String resultType = select.attributeValue("resultType");
                    String sql = select.getText();

                    //sql语句的 ? 匹配
                    Map<Integer, String> parameter = new HashMap<>();
                    Pattern pattern = Pattern.compile("(#\\{(.*?)})");
                    Matcher matcher = pattern.matcher(sql);
                    for (int i = 1; matcher.find(); i++) {
                        // g1 : #{id}
                        String g1 = matcher.group(1);
                        // g2 : id
                        String g2 = matcher.group(2);

                        parameter.put(i, g2);
                        sql = sql.replace(g1, "?");
                    }

                    XNode xNode = new XNode();
                    xNode.setId(id);
                    xNode.setNamespace(namespace);
                    xNode.setParameter(parameter);
                    xNode.setParameterType(parameterType);
                    xNode.setResultType(resultType);
                    xNode.setSql(sql);

                    mapperElement.put(namespace + "." + id, xNode);
                }
            } catch (Exception e1) {
                logger.error(e1.getMessage(),e1);
            } finally {
                try {
                    reader.close();
                } catch (IOException ioException) {
                    logger.error(ioException.getMessage(),ioException);
                }
            }
        }
        return mapperElement;
    }

}
