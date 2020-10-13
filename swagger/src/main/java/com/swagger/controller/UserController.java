package com.swagger.controller;

import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description
 * @Author zouyuxiao
 * @Date 2020-10-08 10:40
 */

@Api(tags="用户模块")
@Controller
public class UserController {
    @ApiOperation(value="用户登录",notes="随边说点啥")
    @ApiImplicitParams({
            @ApiImplicitParam(name="mobile",value="手机号",required=true,paramType="form"),
            @ApiImplicitParam(name="password",value="密码",required=true,paramType="form"),
            @ApiImplicitParam(name="age",value="年龄",required=true,paramType="form",dataType="Integer")
    })
    @PostMapping("/login")
    public void login(@RequestParam String mobile, @RequestParam String password,
                            @RequestParam Integer age){
        //...
    }

    @ApiOperation("获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name="userId", dataType="String", required=true, value="用户 Id")
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @ResponseBody
    @RequestMapping("/list")
    public void list(@RequestParam String userId) {
        // ...
    }

}
