package com.example.admin.controller;

import com.example.commom.controller.BaseApiController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * swagger 接口
 */
@Controller
@RequestMapping("/swagger")
public class SwaggerController extends BaseApiController {
    @RequestMapping("/swagger")
    public String swagger(){
        return "/swagger-ui.html";
    }

    @GetMapping("/swaggerTest")
    public String swaggerTest(){
        return "/user/user";
    }
}
