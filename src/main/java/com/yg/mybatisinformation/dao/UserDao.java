package com.yg.mybatisinformation.dao;

import com.yg.mybatisinformation.pojo.User;

public interface UserDao {
    User selectUserById(int id);
    int updateUserInformation(User user);
    //用户通过id查看自身的用户信息
    //修改自身的信息
}
