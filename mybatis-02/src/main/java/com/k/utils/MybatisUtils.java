package com.k.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//sqlSessionFactory--->sqlSession
public class MybatisUtils {
    //提升作用域
    private static SqlSessionFactory SqlSessionFactory;
    static {
        try {
            String resourse = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resourse);
            SqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static SqlSession getSession(){
        return SqlSessionFactory.openSession();
    }
}
