package com.poi.service.impl;

import com.poi.bean.User;
import com.poi.dao.UserDao;
import com.poi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author zouyuxiao
 * @Date 2020-09-23 11:19
 */
@Service("user")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> list() {
        return userDao.list();
    }

    @Override
    public List<User> findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public User findById2(Long id) {
        return userDao.findById2(id);
    }
}
