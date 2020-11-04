package com.example.user.controller;

import com.example.commom.controller.BaseApiController;
import com.example.commom.core.domain.AjaxResult;
import com.example.commom.utils.StringUtils;
import com.example.commom.utils.poi.ExcelUtil;
import com.example.user.bean.User;
import com.example.user.service.UploadService;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    @Autowired
    private UploadService uploadService;

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

    @PostMapping("/image")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file){
        String url = this.uploadService.uploadImage(file);
        if (StringUtils.isBlank(url)){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(url);
    }
}
