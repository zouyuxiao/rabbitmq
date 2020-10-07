package com.example.admin.controller;

import com.example.commom.controller.BaseApiController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author zouyuxiao
 * @Date 2020-09-25 17:07
 */
@Controller
@RequestMapping("/admin")
public class DemoController extends BaseApiController {

    @RequestMapping("/test")
    public String test(){
        return "test/test";
    }

    @RequestMapping("/test2")
    public String test2(){
        return "test/test2";
    }
}

