package com.redis.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.redis.bean.TScrmMember;
import com.redis.service.ITScrmMemberService;
import com.redis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 会员列表Controller
 * 
 * @author 李学超
 * @date 2020-04-28
 */
@RestController
@RequestMapping("/mem/member")
public class TScrmMemberController
{
    private String prefix = "mem/member";
    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private ITScrmMemberService tScrmMemberService;

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
        List<TScrmMember> list = tScrmMemberService.listPage(size, num);
        return list;
    }

    @RequestMapping("/listPage2")
    public PageInfo<TScrmMember> listPage2(@RequestParam(defaultValue = "1")Integer num, @RequestParam(defaultValue = "10")Integer size,
                                           TScrmMember tScrmMember){
        PageHelper.startPage(num,size);
        List<TScrmMember> list = (List<TScrmMember>) redisUtil.get("member");
        return new PageInfo<TScrmMember>(list);
    }



}
