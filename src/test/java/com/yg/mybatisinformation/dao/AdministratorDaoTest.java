package com.yg.mybatisinformation.dao;

import com.yg.mybatisinformation.pojo.Administrator;
import com.yg.mybatisinformation.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.InputStream;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdministratorDaoTest {
    @Autowired
    public AdministratorDao administratorDao;
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
        this.administratorDao=sqlSession.getMapper(AdministratorDao.class);
    }
    @Test
    public void testAdministratordao(){
        this.administratorDao.deleteAdInformationById(1);
    }

    @Test
    public void testAdInsert(){
       Administrator administrator=new Administrator();
       //administrator.setId(2);
       administrator.setAge(22);
       administrator.setLoginnum("123456789");
       administrator.setName("david");
       administrator.setSex("male");
       administrator.setPassword("qwerty");
       this.administratorDao.InsertAdInformation(administrator);
    }

    @Test
    public void testUserInsert(){
        User user=new User();
        user.setAge(23);
        user.setLoginnum("123466789");
        user.setName("jack");
        user.setPassword("qwert123456");
        user.setSex("male");
        this.administratorDao.InsertUserInfo(user);
    }

    @Test
    public void testupdateAd(){
        Administrator administrator=new Administrator();
        administrator.setId(7);
        administrator.setSex("female");
        this.administratorDao.updateAdInformation(administrator);
    }

    @Test
    public void testselectAdAll(){
        List<Administrator> administratorList=this.administratorDao.selectAdAll();
        for(Administrator  administrator:administratorList){
            System.out.println(administrator.toString());
        }
    }
    @Test
    public void testdeleteAdById(){
        this.administratorDao.deleteAdInformationById(7);
    }

    @Test
    public void testselectAdInfoById(){
        Administrator administrator=this.administratorDao.selectAdInformationById(1);
        System.out.println(administrator.toString());
    }

}