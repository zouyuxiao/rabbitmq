package com.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author zouyuxiao
 * @Date 2020-09-24 13:53
 */
@Controller
@RequestMapping("/thyemleaf")
public class TestControlller{

    @RequestMapping("/hello")
    public String hello(ModelMap modelMap, ModelAndView modelAndView){
        modelMap.addAttribute("hello","你好！");

        List<String> lists = new ArrayList<>();
        lists.add("老龚");
        lists.add("老蔡");
        lists.add("老蔡2");
        lists.add("老蔡3");
        modelMap.addAttribute("lists",lists);

        Map<String,String> map = new HashMap<>();
        map.put("男1", "老蔡");
        map.put("女1", "老蔡2");
        map.put("男2", "老蔡3");
        map.put("男3", "老蔡4");
        modelMap.addAttribute("maps",map);
        return "index";
    }

}
