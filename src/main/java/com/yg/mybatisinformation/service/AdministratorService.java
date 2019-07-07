package com.yg.mybatisinformation.service;

import com.yg.mybatisinformation.pojo.Administrator;
import com.yg.mybatisinformation.pojo.User;

import java.util.List;


public interface    AdministratorService {
    //管理员对于管理员的操作
    List<Administrator> queryAllAd();//查找所有的管理员信息
    boolean deleteAdInfo(int AdId);
    boolean InsertAdInfo(Administrator administrator);
    boolean updateAdInfo(Administrator administrator);
    Administrator selectAdInfoById(int AdId);

    //管理员对于使用者的操作
    List<User> queryAllUser();
    User selectUserById(int UserId);
    boolean updateUserInfo(User user);
    boolean deleteUserInfo(int UserId);
    boolean InsertUserInfo(User user);

}
