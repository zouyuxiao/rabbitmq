package com.cache;

import com.cache.bean.User;
import com.cache.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;

import java.util.List;

@SpringBootTest
class CacheApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private CacheManager cacheManager;

    @Test
    void contextLoads() {
    }

    @Test
    public void list() throws Exception {
        List<User> users1 = userService.list();
        System.out.println(users1);
        List<User> users2 = userService.list();
        System.out.println(users2);
    }
}
