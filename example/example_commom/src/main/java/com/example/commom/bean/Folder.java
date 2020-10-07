package com.example.commom.bean;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 获取文件夹
 * @Author zouyuxiao
 * @Date 2020-09-30 10:21
 */

public class Folder {
    private List path;
    private List name;


    public List getPath() {
        return path;
    }

    public void setPath(List path) {
        this.path = path;
    }

    public List getName() {
        return name;
    }

    public void setName(List name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Folder{" +
                "path=" + path +
                ", name=" + name +
                '}';
    }
}
