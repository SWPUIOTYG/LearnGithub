package com.yg.mybatisinformation.service;

import com.yg.mybatisinformation.pojo.User;

public interface UserService {
    User selectUserById(int id);
    boolean updateUserInformation(User user);
}
