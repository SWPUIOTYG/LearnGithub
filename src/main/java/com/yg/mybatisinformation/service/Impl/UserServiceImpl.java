package com.yg.mybatisinformation.service.Impl;

import com.yg.mybatisinformation.dao.UserDao;
import com.yg.mybatisinformation.pojo.User;
import com.yg.mybatisinformation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User selectUserById(int UserId) {
        return userDao.selectUserById(UserId);
    }

    @Override
    public boolean updateUserInformation(User user) {
        if(user.getId()>0){
            try{
                user.setLogintime(new Date());
                user.setUpdatetime(new Date());
                int effectNum=userDao.updateUserInformation(user);
                if(effectNum>0){
                    return  true;
                }else{
                    throw new RuntimeException("更新信息失败");
                }
            }catch (Exception e){
                throw new RuntimeException("更新信息失败"+e.toString());
            }
        }else{
            throw new RuntimeException("更新的内容不存在");
        }

    }
}
