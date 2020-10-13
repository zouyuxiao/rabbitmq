package com.example.user.bean;


import com.example.commom.annotation.Excel;

import java.util.Date;

/**
 * @Description
 * @Author zouyuxiao
 * @Date 2020-09-23 10:44
 */

public class User {
    @Excel(name = "id")
    private Long id;
    @Excel(name = "用户名")
    private String username;
    @Excel(name = "密码")
    private String password;
    @Excel(name = "年龄")
    private Integer age;
    @Excel(name = "注册时间")
    private Date regTime;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", regTime=" + regTime +
                '}';
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
