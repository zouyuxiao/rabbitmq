package com.visualization.controller;

import com.visualization.bean.User;
import com.visualization.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author zouyuxiao
 * @Date 2020-09-23 14:01
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseApiController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public Map<String,Object> list(){
        List<User> list = userService.list();
        return onDataResp(list);
    }

    @RequestMapping("/hello")
    public String hello(){
        return "你好";
    }
}
