package com.lin.service;

import com.lin.pojo.User;

public interface UserService {
    int add(User user);

    int delete(String id);

    int update (User user);

    User query(User user);
}
