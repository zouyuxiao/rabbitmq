package com.cache.service;


import com.cache.bean.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * @Description
 * @Author zouyuxiao
 * @Date 2020-09-23 11:18
 */
@CacheConfig(cacheNames = "users")
public interface UserService {
    @Cacheable
    List<User> list();
}
