package com.example.user.controller;

import com.example.commom.controller.BaseApiController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author zouyuxiao
 * @Date 2020-09-25 16:28
 */
@Controller
@RequestMapping("/user")
public class TestController extends BaseApiController {

    @RequestMapping("/test")
    public String test(){
        System.out.println("<=====================>");
        return "user/user";
    }
}
