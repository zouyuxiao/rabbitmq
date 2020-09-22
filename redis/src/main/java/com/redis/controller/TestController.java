package com.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

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


    /*@Autowired
    private RestTemplate restTemplate;

    @GetMapping("/testGetApi")
    @ResponseBody
    public String getJson(){
        String url="http://localhost:8089/o2o/getshopbyid?shopId=19";
        //String json =restTemplate.getForObject(url,Object.class);
        ResponseEntity<String> results = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        String json = results.getBody();
        System.out.println(json);
        return json;
    }*/
}
