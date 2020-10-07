package com.example.user;

import com.example.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Description
 * @Author zouyuxiao
 * @Date 2020-09-26 17:43
 */
//@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserTest {
    @Autowired
    private UserService userService;


    @Test
    public void list(){
        // System.out.println(userService.list());
    }

}
