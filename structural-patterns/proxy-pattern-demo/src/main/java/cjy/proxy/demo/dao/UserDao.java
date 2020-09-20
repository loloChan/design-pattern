package cjy.proxy.demo.dao;

import cjy.proxy.demo.annotation.Select;

public interface UserDao {

    @Select("select name from tb_user where userId = #{userId}")
    String findByUserId(String userId);

}
