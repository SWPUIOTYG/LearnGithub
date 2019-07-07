package com.yg.mybatisinformation.dao;

import com.yg.mybatisinformation.pojo.Administrator;
import com.yg.mybatisinformation.pojo.User;

import java.util.List;

public interface AdministratorDao {
    int InsertAdInformation(Administrator administrator);
    int deleteAdInformationById(int id);
    int updateAdInformation(Administrator administrator);
    Administrator selectAdInformationById(int id);
    List<Administrator> selectAdAll();
    //管理员修改管理员信息

    User selectUserInfoById(int id);
    List<User> selectUserAll();
    int deleteUserInfoById(int id);
    int InsertUserInfo(User user);
    int updateUserInfo(User user);
    //管理员修改使用者信息

    //dao层与mybatis结合 通过sql语句 做增删改查的功能

    //service层将dao层的增删改查整合到一块  与事务相关


}
