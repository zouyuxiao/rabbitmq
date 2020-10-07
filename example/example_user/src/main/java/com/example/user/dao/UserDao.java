package com.example.user.dao;

import com.example.user.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @Author zouyuxiao
 * @Date 2020-09-23 11:08
 */
@Repository
public interface UserDao {
    List<User> list();
    List<User> findById(Long id);
    User findById2(Long id);
}
