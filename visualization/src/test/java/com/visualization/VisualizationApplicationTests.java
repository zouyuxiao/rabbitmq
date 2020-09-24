package com.visualization;

import com.visualization.bean.User;
import com.visualization.service.UserService;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

//@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class VisualizationApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    UserService userService;

    @Test
    public void list(){
        List<User> list = userService.list();
        System.out.println(list);

        List<User> list1 = userService.findById((long) 1);
        System.out.println(list1);
    }

}
