package com.k.dao;

import com.k.pojo.User;

import javax.naming.spi.ObjectFactoryBuilder;
import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserLike(String value);
    //查询全部用户
    List<User> getUserList();
    //根据id查询用户
    User getUserById(int id);
    User getUserById2(Map<String,Object> map);
    //insert
    int addUser(User user);
    //修改
    int updateUser(User user);
    int addUser2(Map<String,Object> map);
    //删除
    int deleteUser(int id);
    int updateUserByName(User user);
}


