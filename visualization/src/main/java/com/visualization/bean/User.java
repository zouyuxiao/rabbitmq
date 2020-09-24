package com.visualization.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.xml.crypto.Data;

/**
 * @Description
 * @Author zouyuxiao
 * @Date 2020-09-23 10:44
 */

public class User {
    private Long id;
    private String username;
    private String password;
    private Integer age;
    private Data regTime;

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

    public Data getRegTime() {
        return regTime;
    }

    public void setRegTime(Data regTime) {
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
