package com.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author zouyuxiao
 * @Date 2020-10-08 10:03
 */
@RestController
@Api(tags = "测试模块")
@RequestMapping("/test")
public class TestController {


    @GetMapping("test1")
    @ApiOperation(value = "测试接口")
    public void test1(){
        System.out.println("test1");
    }

    @GetMapping("test2")
    @ApiOperation(value = "测试接口2")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "param",value = "参数一"),
            @ApiImplicitParam(name = "param2",value = "参数2")
    })
    public void test2(String param,String param2){
        System.out.println("test1");
    }


}
