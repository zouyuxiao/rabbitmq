package com.example.admin.controller;

import com.example.commom.controller.BaseApiController;
import com.example.user.bean.User;
import com.example.user.service.UserService;
import com.example.user.service.UserTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author zouyuxiao
 * @Date 2020-09-25 17:36
 */
@RestController
@RequestMapping("/userTest")
public class UserTestController extends BaseApiController {


    @Autowired
    private UserTestService userTestService;

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public Map<String,Object> list(){
        List<User> users = userService.list();
        return onDataResp(users);
    }
}
