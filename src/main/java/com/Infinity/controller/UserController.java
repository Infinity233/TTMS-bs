package com.Infinity.controller;

import com.Infinity.pojo.User;
import com.Infinity.service.UserService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/user")
public class UserController {

//      field注入
//    @Autowired
//    UserService userService;

    // 构造器注入
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
//      setter注入
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }

    @RequestMapping("/login")
    public String userLogin(String username, String password, HttpSession session) {
        User user = userService.login(username, password);
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

    @RequestMapping("/selectAll")
    public String selectAll() {

        Gson gson = new Gson();
        JsonObject finalJson = new JsonObject();
        JsonArray jsonArray = new JsonArray();

        List<User> users = userService.selectAll();

        finalJson.addProperty("code", 0);
        finalJson.addProperty("msg", "");
        finalJson.addProperty("count", users.size());
        finalJson.add("data", gson.toJsonTree(users));
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

    @RequestMapping(value="/{userId}", method=POST)
    public String selectById(@PathVariable Integer userId) {
        Gson gson = new Gson();
        JsonObject finalJson = new JsonObject();

        User user = userService.selectById(userId);

        finalJson.add("user", gson.toJsonTree(user));

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

    @RequestMapping(value = "/update", method = POST)
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

































