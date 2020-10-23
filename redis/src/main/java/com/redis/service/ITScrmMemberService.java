package com.redis.service;

import com.redis.bean.TScrmMember;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 会员列表Service接口
 * 
 * @author 李学超
 * @date 2020-04-28
 */
@Repository
public interface ITScrmMemberService 
{
    /**
     * 查询会员列表列表
     * 
     * @param tScrmMember 会员列表
     * @return 会员列表集合
     */
    public List<TScrmMember> selectTScrmMemberList(TScrmMember tScrmMember);

    List<TScrmMember> listPage(Long size,Long num);

}
