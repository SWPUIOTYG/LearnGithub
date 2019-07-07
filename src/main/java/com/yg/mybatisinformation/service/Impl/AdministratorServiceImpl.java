package com.yg.mybatisinformation.service.Impl;

import com.yg.mybatisinformation.dao.AdministratorDao;
import com.yg.mybatisinformation.pojo.Administrator;
import com.yg.mybatisinformation.pojo.User;
import com.yg.mybatisinformation.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AdministratorServiceImpl  implements AdministratorService {

    @Autowired
    private AdministratorDao administratorDao;

//    @Autowired
//    private UserDao userDao;

    @Override
    public List<Administrator> queryAllAd() {
        return administratorDao.selectAdAll();
    }

    @Override
    public boolean deleteAdInfo(int AdId) {
        if(AdId>0){
            try{
                int effectNum=administratorDao.deleteAdInformationById(AdId);//删除成功
                if(effectNum>0){
                    return true;
                }else
                     throw new RuntimeException("删除管理员信息失败");
            }catch (Exception e){
                throw new RuntimeException("删除管理员信息失败："+e.toString());
            }
        }else {
            throw new RuntimeException("被删除着信息不能为空");
        }
    }

    @Transactional //并不是所有异常都会回滚
    @Override
    public boolean InsertAdInfo(Administrator administrator) {
        if(administrator.getName()!=null && !"".equals(administrator.getName())){
            administrator.setLogintime(new Date());
            administrator.setUpdatetime(new Date());
            try {
                   int effectNum= administratorDao.InsertAdInformation(administrator);
                   if(effectNum>0){
                       return true;
                   }else{
                       throw  new RuntimeException("信息插入失败");
                   }
            }catch (Exception e){
                throw new RuntimeException("信息插入失败"+e.toString());
            }
        }else {
            throw new RuntimeException("插入信息不能为空");
        }

    }

    @Override
    public boolean updateAdInfo(Administrator administrator) {
        if(administrator.getId()>0){
            try{
                administrator.setLogintime(new Date());
                administrator.setUpdatetime(new Date());
                int effectNum=administratorDao.updateAdInformation(administrator);
                if(effectNum>0){
                    return  true;
                }else{
                    throw new RuntimeException("信息修改失败");
                }
            }catch (Exception e){
                    throw new RuntimeException("信息修改失败"+e.toString());
            }
        }else
            throw new RuntimeException("被修改的信息为空");

    }

    @Override
    public Administrator selectAdInfoById(int AdId) {
        return administratorDao.selectAdInformationById(AdId);
    }



    @Override
    public List<User> queryAllUser() {
        return administratorDao.selectUserAll();
    }

    @Override
    public User selectUserById(int UserId) {
        return administratorDao.selectUserInfoById(UserId);
    }


    @Override
    public boolean updateUserInfo(User user) {
        if(user.getId()>0){
            try{
                user.setLogintime(new Date());
                user.setUpdatetime(new Date());
                int effectNum=administratorDao.updateUserInfo(user);
                if(effectNum>0){
                    return  true;
                }else{
                    throw new RuntimeException("信息修改失败");
                }
            }catch (Exception e){
                throw new RuntimeException("信息修改失败"+e.toString());
            }
        }else
            throw new RuntimeException("被修改的信息为空");

    }

    @Override
    public boolean deleteUserInfo(int UserId) {
        if(UserId>0){
            try{
                int effectNum=administratorDao.deleteUserInfoById(UserId);//删除成功
                if(effectNum>0){
                    return true;
                }else
                    throw new RuntimeException("删除用户信息失败");
            }catch (Exception e){
                throw new RuntimeException("删除用户信息失败："+e.toString());
            }
        }else {
            throw new RuntimeException("被删除着信息不能为空");
        }
    }

    @Transactional
    @Override
    public boolean InsertUserInfo(User user) {
        if(user.getName()!=null && !"".equals(user.getName())){
            user.setLogintime(new Date());
            user.setUpdatetime(new Date());
            try {
                int effectNum= administratorDao.InsertUserInfo(user);
                if(effectNum>0){
                    return true;
                }else{
                    throw  new RuntimeException("信息插入失败");
                }
            }catch (Exception e){
                throw new RuntimeException("信息插入失败"+e.toString());
            }
        }else {
            throw new RuntimeException("插入信息不能为空");
        }
    }



}
