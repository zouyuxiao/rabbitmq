package com.redis.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description
 * @Author zouyuxiao
 * @Date 2020-09-21 10:34
 */

public class Redis implements Serializable {
    private Long id;
    private String guid;
    private String name;
    private String age;
    private Date createTime;

    @Override
    public String toString() {
        return "Redis{" +
                "id=" + id +
                ", guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
