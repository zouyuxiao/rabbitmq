package com.excel.user.controller;

import com.excel.common.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ${邹} on 2018/11/2.
 * 描述：
 */
@Controller
@RequestMapping("/main")
public class MainController extends BaseController {

    @GetMapping("/views/{page}")
    public String test(@PathVariable String page){
        return "/views/" + page;
    }

    @GetMapping("/index")
    public String main(@PathVariable String page){
        return "/views/index.html";
    }



}
