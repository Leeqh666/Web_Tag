package com.example.webtag.service.impl;

import com.example.webtag.dao.UserMapper;
import com.example.webtag.domain.User;
import com.example.webtag.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * create by Lee
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public int add(User user) {
        return this.userMapper.insert(user);
    }

    @Override
    public int update(User user) {
        return this.userMapper.updateByPrimaryKey(user);
    }

    @Override
    public String select(String userName) {
        return this.userMapper.select(userName);
    }

    @Override
    public int select_exists(String userName) {
        return this.userMapper.select_exists(userName);
    }
}
