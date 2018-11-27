package com.example.webtag.service;

import com.example.webtag.domain.User;

public interface UserService {
    int add(User user);
    int update(User user);
    String select(String userName);
    int select_exists(String userName);
}
