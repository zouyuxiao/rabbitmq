package com.swagger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author zouyuxiao
 * @Date 2020-10-19 10:31
 */
@Controller
public class Main {
    @GetMapping("/swagger")
    public String index(){
        return "redirect:/swagger-ui.html";
    }
}
