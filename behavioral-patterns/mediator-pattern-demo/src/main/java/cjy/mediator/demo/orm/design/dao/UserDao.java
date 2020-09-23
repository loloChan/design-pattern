package cjy.mediator.demo.orm.design.dao;

import cjy.mediator.demo.orm.vo.User;

import java.util.List;

public interface UserDao {

    List<User> findAllUser();

    User findUserById(Integer id);

}
