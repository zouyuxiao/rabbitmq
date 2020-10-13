package com.poi.service;

import com.poi.bean.User;

import java.util.List;

/**
 * @Description
 * @Author zouyuxiao
 * @Date 2020-09-23 11:18
 */

public interface UserService {
    List<User> list();
    List<User> findById(Long id);
    User findById2(Long id);
}
