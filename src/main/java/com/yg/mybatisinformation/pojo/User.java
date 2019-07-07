package com.yg.mybatisinformation.pojo;

import java.util.Date;

public class User {
    private Integer id;
    private String name;
    private String sex;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", loginnum='" + loginnum + '\'' +
                ", password='" + password + '\'' +
                ", logintime=" + logintime +
                ", updatetime=" + updatetime +
                '}';
    }

    private Integer age;
    private String loginnum;
    private String password;
    private Date logintime;
    private Date updatetime;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLoginnum() {
        return loginnum;
    }

    public void setLoginnum(String loginnum) {
        this.loginnum = loginnum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


}
