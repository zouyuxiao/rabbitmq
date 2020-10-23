package com.redis.service.impl;

import com.redis.bean.TScrmMember;

import com.redis.dao.TScrmMemberDao;
import com.redis.service.ITScrmMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 会员列表Service业务层处理
 *
 */
@Service
public class TScrmMemberServiceImpl implements ITScrmMemberService
{
    @Autowired
    private TScrmMemberDao tScrmMemberMapper;

    /**
     * 查询会员列表列表
     * 
     * @param tScrmMember 会员列表
     * @return 会员列表
     */
    @Override
    public List<TScrmMember> selectTScrmMemberList(TScrmMember tScrmMember)
    {
        return tScrmMemberMapper.selectTScrmMemberList(tScrmMember);
    }

    @Override
    public List<TScrmMember> listPage(Long size, Long num) {
        return tScrmMemberMapper.listPage(size, num);
    }


}
