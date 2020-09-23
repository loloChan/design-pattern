package cjy.mediator.demo.orm.undesign;

import cjy.mediator.demo.orm.vo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 直接通过jdbc访问数据库
 */
public class JDBCUtil {

    private static Logger logger = LoggerFactory.getLogger(JDBCUtil.class);

    //jdbc:mysql://127.0.0.1:3306/chenjianyuan?autoReconnect=true&useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai
    private static final String url = "jdbc:mysql://127.0.0.1:3306/chenjianyuan?serverTimezone=Asia/Shanghai";
    private static final String user = "root";
    private static final String password = "root";
    private static final String driver = "com.mysql.cj.jdbc.Driver";

    public static void main(String[] args) throws Exception {

        //加载驱动
        Class.forName(driver);

        //获取数据库连接
        Connection connection = DriverManager.getConnection(url, user, password);

        //数据库操作
        String sql = "select * from tb_user";
        PreparedStatement pstmt = connection.prepareStatement(sql);

        //执行sql
        ResultSet resultSet = pstmt.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            logger.info("查询结果：id:{} 姓名:{} 年龄:{}", id, name, age);
        }

        connection.close();
    }

}
