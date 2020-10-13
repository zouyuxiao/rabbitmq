package com.example.user.controller;

import com.example.commom.controller.BaseApiController;
import com.example.commom.core.domain.AjaxResult;
import com.example.commom.utils.poi.ExcelUtil;
import com.example.user.bean.User;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author zouyuxiao
 * @Date 2020-09-25 16:28
 */
@RestController
@RequestMapping("/user")
public class TestController extends BaseApiController {

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public String test(){
        System.out.println("<=====================>");
        return "user/user";
    }


    @GetMapping("/export")
    public AjaxResult export(User user)
    {
        List<User> users = userService.list();
        System.out.println("users-->"+users);
        List<User> list = new ArrayList<User>(users);
        ExcelUtil<User> util = new ExcelUtil<User>(User.class);
        return util.exportExcel(list, "用户数据");
    }
}
