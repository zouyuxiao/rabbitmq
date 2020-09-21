package com.redis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author zouyuxiao
 * @Date 2020-09-21 10:56
 */

@Controller
public class TestController {

    @RequestMapping("/index")
    public String mian(){
        return "index.html";
    }
}
