package com.yg.mybatisinformation.dao;

import com.yg.mybatisinformation.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class UserDaoTest {
    private UserDao userDao;

    @Before
    public void setUp() throws Exception {
        String resource="mybatis-config.xml";
        //指定配置文件
        InputStream inputStream= Resources.getResourceAsStream(resource);
        //读取配置文件
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        //构建sqlSessionFactory
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        //获取sqlSession
        this.userDao=sqlSession.getMapper(UserDao.class);
    }  //测试类先获取sqlSession
    @Test
    public  void testupdateUserInfo(){
        User user=new User();
        user.setId(1);
        user.setSex("female");
        this.userDao.updateUserInformation(user);
    }
}