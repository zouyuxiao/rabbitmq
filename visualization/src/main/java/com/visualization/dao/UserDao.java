package com.visualization.dao;

import com.visualization.bean.User;

import java.util.List;

/**
 * @Description
 * @Author zouyuxiao
 * @Date 2020-09-23 11:08
 */

public interface UserDao {
    List<User> list();
    List<User> findById(Long id);
    User findById2(Long id);
}
