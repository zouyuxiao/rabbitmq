package com.restTemplate.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Author zouyuxiao
 * @Date 2020-09-21 16:55
 */
@RestController
public class TestController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/testGetApi")
    public String getJson(){
        String url="http://192.168.128.34:8089/message-center/scrm/coupon/syncAppRange";
        //String json =restTemplate.getForObject(url,Object.class);
        ResponseEntity<String> results = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        String json = results.getBody();
        System.out.println(json);
        return json;
    }

    /*
        springboot使用restTemplate post提交值 restTemplate post值
        post提交有 FormData和Payload 两种形式：
        第一种是formdata形式，在header参数里可以直接看到
        payload则封装成json格式post过去，获取以后需要再解析成实体。

        restTemplate post json格式
        使用阿里巴巴的json包 com.alibaba.fastjson
        代码demo如下：
        url='http://posturl';JSONObject postData = new JSONObject();
        postData.put("shopid", 1);
        JSONObject json = restTemplate.postForEntity(url, postData, JSONObject.class).getBody();

        如果要使用post formdata形式则需要
        使用RestTemplate发送multipart/form-data格式的数据
        String url = 'http://posturl';
        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("shopid","1");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        return restTemplate.postForEntity(url, request,String.class);

        对header进行请求头设置，如果不设置也可以直接post那么就是如下的
        String url = 'http://posturl';
        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("shopid","1");
        return restTemplate.postForEntity(url, map,String.class);
      */
    @PostMapping("/testPostApi")
    public JSONObject postJson(){
        String url="http://192.168.128.34:8089/message-center/scrm/coupon/syncAppRange";
        JSONObject postData = new JSONObject();
        postData.put("id", 1);
        JSONObject json = restTemplate.postForEntity(url, postData, JSONObject.class).getBody();
        System.out.println("===========>"+json);
        return json;
    }

}
