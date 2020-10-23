package com.redis.controller;

import com.redis.bean.Redis;
import com.redis.bean.TScrmMember;
import com.redis.service.ITScrmMemberService;
import com.redis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


/**
 * @Description redis
 * @Author zouyuxiao
 * @Date 2020-09-21 10:36
 */

@Slf4j
@RequestMapping("/redis")
@RestController
public class RedisController {

    private static int ExpireTime = 60;   // redis中存储的过期时间60s

    @Resource
    private RedisUtil redisUtil;

    @Autowired
    private ITScrmMemberService tScrmMemberService;

    @RequestMapping("set")
    public boolean redisset(String key, String value){
        Redis redis =new Redis();
        redis.setId(Long.valueOf(1));
        redis.setGuid(String.valueOf(1));
        redis.setName("zhangsan");
        redis.setAge(String.valueOf(20));
        redis.setCreateTime(new Date());

        //return redisUtil.set(key,userEntity,ExpireTime);

        return redisUtil.set(key,value);
    }

    @RequestMapping("get")
    public Object redisget(String key){
        return redisUtil.get(key);
    }

    @RequestMapping("expire")
    public boolean expire(String key){
        return redisUtil.expire(key,ExpireTime);
    }



    /**
     * 查询会员列表列表
     */
    @PostMapping("/list")
    @ResponseBody
    public List<TScrmMember> list(TScrmMember tScrmMember)
    {
        List<TScrmMember> list = tScrmMemberService.selectTScrmMemberList(tScrmMember);
        return list;
    }


    @PostMapping("/listPage")
    @ResponseBody
    public List<TScrmMember> listPage(Long size,Long num)
    {
        long startTime = System.currentTimeMillis();
        List<TScrmMember> list = tScrmMemberService.listPage(size, num);
        redisUtil.set("memberListPage", list);
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        System.out.println("执行时间为---》"+time);
        return list;
    }

}
