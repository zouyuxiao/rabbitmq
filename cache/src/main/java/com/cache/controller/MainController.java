package com.cache.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by ${邹} on 2018/11/2.
 * 描述：
 */
@Controller
public class MainController extends BaseController {

    @GetMapping("/test/{page}")
    public String test(@PathVariable String page){
        return "/test/" + page;
    }

    @GetMapping("/{page}")
    public String main(@PathVariable String page){
        return page;
    }

}
