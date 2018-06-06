package com.Infinity.controller;

import com.Infinity.pojo.User;
import com.Infinity.service.LoginService;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping("/user")
    @ResponseBody
    public String userLogin(String username, String password, HttpSession session) {
        System.out.println("666");
        User user = loginService.login(username, password);
        JsonObject jsonObject = new JsonObject();

        if (user == null) {
            jsonObject.addProperty("errorMsg", "用户名或密码错误");
        }
        else {
            jsonObject.addProperty("success",1);
            session.setAttribute("currentUser", user);
        }

        return jsonObject.toString();
    }
}
