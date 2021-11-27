package com.lin.dao;

import com.lin.pojo.User;

public interface UserMapper {
    int add(User user);

    int delete(String id);

    int update (User user);

    User query(User user);
}
