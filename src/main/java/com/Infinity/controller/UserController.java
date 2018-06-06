package com.Infinity.controller;

import com.Infinity.pojo.User;
import com.Infinity.service.UserService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/selectAll")
    @ResponseBody
    public String selectAll() {

        Gson gson = new Gson();
        JsonObject finalJson = new JsonObject();
        JsonArray jsonArray = new JsonArray();

        finalJson.addProperty("code", 0);
        finalJson.addProperty("msg", "");

        List<User> users = userService.selectAll();

        finalJson.addProperty("count", users.size());

        JsonObject t = new JsonObject();
        for (User user : users) {
            jsonArray.add(gson.toJsonTree(user));
        }

        finalJson.add("data", jsonArray);
        return finalJson.toString();
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delUsers(String delIds) {

        JsonObject finalJson = new JsonObject();


        return finalJson.toString();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String addUser(User user) {

        JsonObject finalJson = new JsonObject();

        String errorMsg = null;

        int resultNum = 0;

        if (user.getId() == null) {
            // update
            if (userService.isExist(user.getUsername())) {
                errorMsg = "用户名已存在";
            } else {
                resultNum = userService.insert(user);
            }

        } else {
            // add
            resultNum = userService.update(user);
        }

        if (resultNum == 0) {
            errorMsg = "修改失败";
        }

        if(errorMsg!=null) {
            finalJson.addProperty("errorMsg",errorMsg);
        } else {
            finalJson.addProperty("success",1);
        }

        return finalJson.toString();
    }
}

































