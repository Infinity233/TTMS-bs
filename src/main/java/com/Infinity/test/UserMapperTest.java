package com.Infinity.test;

import com.Infinity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/usertest")
public class UserMapperTest {

    @Autowired
    UserService userService;

    @RequestMapping("/exist")
    public void exist(String username) {

        System.out.println(userService.isExist(username));

    }

    @RequestMapping("dels")
    public void dels() {

        List<String> list = new ArrayList<>();
        list.add("4");
    }

}
