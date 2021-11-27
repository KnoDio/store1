package com.lin.service;

import com.lin.dao.UserMapper;
import com.lin.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService{

    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    public int add(User user) {
        return userMapper.add(user);
    }

    public int delete(String id) {
        return 0;
    }

    public int update(User user) {
        return userMapper.update(user);
    }

    public User query(User user) {
        return userMapper.query(user);
    }


}
