package com.k.dao;

import com.k.pojo.User;
import com.k.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UserDaoTest {
    @Test
    public void test(){
        SqlSession sqlSession=MybatisUtils.getSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        List<User> userList=userMapper.getUserList();
        for(User user:userList){
            System.out.println(user.toString());
        }
        sqlSession.close();
    }
    @Test
    public void getUserById(){
        SqlSession sqlSession= MybatisUtils.getSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        User user1=userMapper.getUserById(1);
        System.out.println(user1.toString());

        sqlSession.close();
    }
    @Test
    public void getUserById2(){
        SqlSession sqlSession= MybatisUtils.getSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map=new HashMap<>();
        map.put("id",88);
        System.out.println(userMapper.getUserById2(map).toString());

        sqlSession.close();
    }
    @Test
    public void getUserLike(){
        SqlSession sqlSession= MybatisUtils.getSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        List<User> list=userMapper.getUserLike("%李%");
        for(User user:list){
            System.out.println(user.toString());
        }
        sqlSession.close();
    }
    @Test
    public void addUser(){
        SqlSession sqlSession= MybatisUtils.getSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        userMapper.addUser(new User(4,"hh","1223"));
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void UpdateUser(){
        SqlSession sqlSession= MybatisUtils.getSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        userMapper.updateUser(new User(2,"tom","520"));

        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void deleteUser(){
        SqlSession sqlSession= MybatisUtils.getSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUser(88);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void updateUserByName(){
        SqlSession sqlSession= MybatisUtils.getSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        userMapper.updateUserByName(new User(8,"tom","1243"));
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void addUser2(){
        SqlSession sqlSession= MybatisUtils.getSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map=new HashMap<>();
        map.put("userid",88);
        map.put("pwd","1212321");
        userMapper.addUser2(map);
        sqlSession.commit();
        sqlSession.close();
    }
}
