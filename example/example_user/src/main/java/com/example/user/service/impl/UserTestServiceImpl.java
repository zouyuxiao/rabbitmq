package com.example.user.service.impl;

import com.example.user.service.UserTestService;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author zouyuxiao
 * @Date 2020-09-26 08:37
 */
@Service
public class UserTestServiceImpl implements UserTestService {
    @Override
    public long test() {
        return 1;
    }
}
