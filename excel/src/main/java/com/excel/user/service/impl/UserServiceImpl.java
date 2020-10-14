package com.excel.user.service.impl;


import com.excel.user.bean.User;
import com.excel.user.dao.UserDao;
import com.excel.user.service.UserService;
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

    @Override
    public long insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public long deleteAll(List<Long> ids) {
        return userDao.deleteAll(ids);
    }

    @Override
    public List<User> findAllById(List<Long> ids) {
        return userDao.findAllById(ids);
    }
}
