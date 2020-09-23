package com.visualization.service.impl;

import com.visualization.bean.User;
import com.visualization.dao.UserDao;
import com.visualization.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author zouyuxiao
 * @Date 2020-09-23 11:19
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> list() {
        return userDao.list();
    }
}
