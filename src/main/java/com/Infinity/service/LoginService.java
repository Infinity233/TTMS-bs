package com.Infinity.service;

import com.Infinity.dao.UserMapper;
import com.Infinity.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    UserMapper userMapper;

    public User login(String username, String password) {

        User resultUser = userMapper.login(username, password);

        return resultUser;
    }
}
