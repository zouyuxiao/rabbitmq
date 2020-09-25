package com.visualization.controller;

import com.visualization.bean.User;
import com.visualization.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author zouyuxiao
 * @Date 2020-09-23 14:01
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseApiController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    @ResponseBody
    public Map<String,Object> list(){
        List<User> list = userService.list();
        return onDataResp(list);
    }

    @GetMapping("/list2")
    public String list2(ModelMap modelMap){
        List<User> list = userService.list();
        System.out.println("=====>"+list);
        modelMap.addAttribute("users",list);

        List<User> list1 = userService.findById((long) 1);
        System.out.println("=========>"+list1);
        modelMap.addAttribute("list1",list1);

        User user = userService.findById2((long) 3);
        modelMap.addAttribute("users",user);
        return "thymeleaf/list";
    }

    @GetMapping("/list3")
    public String list3(ModelMap modelMap){
        return "thymeleaf/localStorage";
    }


}
