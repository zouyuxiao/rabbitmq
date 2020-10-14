package com.excel;

import com.excel.user.bean.User;
import com.excel.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class ExcelApplicationTests {

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
        User user = new User();
        user.setAge(12);
        user.setUsername("sfmmfm");
        user.setPassword("12");
        user.setRegTime(new Date());
        userService.insert(user);
    }

    @Test
    public void test(){
        System.out.println(userService.list());
    }

}
