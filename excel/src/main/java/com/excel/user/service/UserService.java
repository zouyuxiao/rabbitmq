package com.excel.user.service;

import com.excel.user.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @Author zouyuxiao
 * @Date 2020-09-23 11:18
 */
@Repository
public interface UserService {
    List<User> list();
    List<User> findById(Long id);
    User findById2(Long id);
    long insert(User user);
    // 批量删除
    long deleteAll(List<Long> ids);
    // 批量查询
    List<User> findAllById(List<Long> ids);
}
