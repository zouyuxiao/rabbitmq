package com.visualization.service;

import com.visualization.bean.User;
import org.springframework.stereotype.Service;

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

    User login(String username,String password);

    User findUserById(Long id);
}
