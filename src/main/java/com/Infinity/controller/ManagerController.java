package com.Infinity.controller;

import com.Infinity.pojo.Manager;
import com.Infinity.service.ManagerService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    ManagerService managerService;

    @RequestMapping("/login")
    public String managerLogin(String username, String password, HttpSession session) {
        Manager manager = managerService.login(username, password);
        JsonObject jsonObject = new JsonObject();

        if (manager == null) {
            jsonObject.addProperty("errorMsg", "用户名或密码错误");
        }
        else {
            jsonObject.addProperty("success",1);
            session.setAttribute("currentManager", manager);
        }

        return jsonObject.toString();
    }
    
    @RequestMapping("/selectAll")
    public String selectAll() {

        Gson gson = new Gson();
        JsonObject finalJson = new JsonObject();
        JsonArray jsonArray = new JsonArray();

        finalJson.addProperty("code", 0);
        finalJson.addProperty("msg", "");

        List<Manager> managers = managerService.selectAll();

        finalJson.addProperty("count", managers.size());

        for (Manager manager : managers) {
            jsonArray.add(gson.toJsonTree(manager));
        }

        finalJson.add("data", jsonArray);
        return finalJson.toString();
    }

    @RequestMapping("/mohuSelect")
    public String selectByUsername(String username) {

        if (username == null || username.equals("")) {
            return selectAll();
        }

        Gson gson = new Gson();
        JsonObject finalJson = new JsonObject();
        JsonArray jsonArray = new JsonArray();

        System.out.println(username);

        finalJson.addProperty("code", 0);
        finalJson.addProperty("msg", "");

        List<Manager> managers = managerService.serachManager(username);

        finalJson.addProperty("count", managers.size());

        JsonObject t = new JsonObject();
        for (Manager tManager : managers) {
            jsonArray.add(gson.toJsonTree(tManager));
        }

        finalJson.add("data", jsonArray);
        return finalJson.toString();
    }

    @RequestMapping("/delete")
    public String delManagers(String delIds) {

        String errorMsg = "";
        JsonObject finalJson = new JsonObject();

        String[] delId = delIds.split(",");

        int delNum = managerService.delete(delId);

        if (delNum == 0) {
            finalJson.addProperty("errorMsg", "删除失败");
        }

        finalJson.addProperty("success", 1);

        return finalJson.toString();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String addManager(Manager manager) {

        JsonObject finalJson = new JsonObject();

        String errorMsg = null;

        int resultNum = 0;

        if (manager.getId() == null) {
            // update
            if (managerService.isExist(manager.getUsername())) {
                errorMsg = "用户名已存在";
            } else {
                resultNum = managerService.insert(manager);
            }

        } else {
            // add
            resultNum = managerService.update(manager);
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









































