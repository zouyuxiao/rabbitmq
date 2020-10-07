package com.example.user.service.impl;

import com.example.user.bean.User;
import com.example.user.dao.UserDao;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author zouyuxiao
 * @Date 2020-09-23 11:19
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;


    public List<User> list() {
        return userDao.list();
    }

    public List<User> findById(Long id) {
        return userDao.findById(id);
    }

    public User findById2(Long id) {
        return userDao.findById2(id);
    }
}
