package com.Infinity.service;

import com.Infinity.dao.UserMapper;
import com.Infinity.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public List<User> selectAll() {

        return userMapper.selectAll();
    }

    public User login(String username, String password) {

        User resultUser = userMapper.login(username, password);

        return resultUser;
    }

    public List<User> serachUser(String username) {

        List<User> list = userMapper.selectByUsernameMohu(username);
        return list;
    }

    public int insert(User user) {

        return userMapper.insert(user);
    }

    public int update(User user) {

        return userMapper.updateByPrimaryKeySelective(user);
    }

    public int delete(String[] list) {

        return userMapper.deleteByIds(list);
    }


    public boolean isExist(String username) {

        Boolean exist = true;

        if(userMapper.selectByUsername(username)==0) {
            exist = false;
        }

        return exist;
    }
}
