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
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/selectAll")
    public String selectAll() {

        Gson gson = new Gson();
        JsonObject finalJson = new JsonObject();
        JsonArray jsonArray = new JsonArray();

        finalJson.addProperty("code", 0);
        finalJson.addProperty("msg", "");

        List<User> users = userService.selectAll();

        finalJson.addProperty("count", users.size());

        for (User user : users) {
            jsonArray.add(gson.toJsonTree(user));
        }

        finalJson.add("data", jsonArray);
        return finalJson.toString();
    }

    @RequestMapping("/selectByUsername")
    public String selectByUsername(String username) {

        if (username == null || username.equals("")) {
            return selectAll();
        }

        Gson gson = new Gson();
        JsonObject finalJson = new JsonObject();
        JsonArray jsonArray = new JsonArray();

        User user = new User();
        user.setUsername(username);

        finalJson.addProperty("code", 0);
        finalJson.addProperty("msg", "");

        List<User> users = userService.serachUser(username);

        finalJson.addProperty("count", users.size());

        for (User tUser : users) {
            jsonArray.add(gson.toJsonTree(tUser));
        }

        finalJson.add("data", jsonArray);
        return finalJson.toString();
    }

    @RequestMapping("/delete")
    public String delUsers(String delIds) {

        JsonObject finalJson = new JsonObject();

        String[] delId = delIds.split(",");

        int delNum = userService.delete(delId);

        if (delNum == 0) {
            finalJson.addProperty("errorMsg", "删除失败");
        }

        finalJson.addProperty("success", 1);

        return finalJson.toString();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
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

        if (errorMsg == null && resultNum == 0) {
            errorMsg = "修改失败";
        }

        if (errorMsg != null) {
            finalJson.addProperty("errorMsg", errorMsg);
        } else {
            finalJson.addProperty("success", 1);
        }
        System.out.println(finalJson.toString());
        return finalJson.toString();
    }
}

































