package com.Infinity.controller;

import com.Infinity.pojo.Perform;
import com.Infinity.service.PerformService;
import com.Infinity.service.TicketService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/perform/")
public class PerformController {
    
    @Autowired
    PerformService performService;

    @Autowired
    TicketService ticketService;

    @RequestMapping("selectAll")
    public String selectAll() {

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm")
                .create();
        JsonObject finalJson = new JsonObject();
        JsonArray jsonArray = new JsonArray();

        List<Perform> users = performService.selectAll();

        finalJson.addProperty("code", 0);
        finalJson.addProperty("msg", "");
        finalJson.addProperty("count", users.size());
        finalJson.add("data", gson.toJsonTree(users));
        return finalJson.toString();
    }

    @RequestMapping("selectByFilmId")
    public String selectByFilmId(Integer id) {

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm")
                .create();
        JsonObject finalJson = new JsonObject();

        List<Perform> users = performService.selectByFilmId(id);

        finalJson.addProperty("code", 0);
        finalJson.addProperty("msg", "");
        finalJson.addProperty("count", users.size());
        finalJson.add("data", gson.toJsonTree(users));
        return finalJson.toString();
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addPerform(String filmId, String studioId, String price, String publishDate, String startTime) {

        JsonObject jsonObject = new JsonObject();
        Perform perform = new Perform();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        perform.setPrice(Float.parseFloat(price));
        perform.setSold(0);
        perform.setFilmId(Integer.parseInt(filmId));
        perform.setStudioId(Integer.parseInt(studioId));

        try {

            String[] time = startTime.split(" - ");

            Date start = sdf.parse(publishDate+" "+time[0]);
            Date end = sdf.parse(publishDate+" "+time[1]);

            perform.setStartTime(start);
            perform.setEndTime(end);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        performService.insert(perform);
        ticketService.insertByPerform(perform);
        return jsonObject.toString();
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String updatePerform(String id, String filmId, String studioId, String price, String publishDate, String startTime) {

        JsonObject jsonObject = new JsonObject();
        Perform perform = new Perform();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        perform.setId(Integer.parseInt(id));
        perform.setPrice(Float.parseFloat(price));
        perform.setSold(0);
        perform.setFilmId(Integer.parseInt(filmId));
        perform.setStudioId(Integer.parseInt(studioId));

        try {

            String[] time = startTime.split(" - ");

            Date start = sdf.parse(publishDate+" "+time[0]);
            Date end = sdf.parse(publishDate+" "+time[1]);

            perform.setStartTime(start);
            perform.setEndTime(end);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        performService.update(perform);
        return jsonObject.toString();
    }

    @RequestMapping("/delete")
    public String delPerforms(String delIds) {

        JsonObject finalJson = new JsonObject();

        String[] delId = delIds.split(",");

        int delNum = performService.delete(delId);
        ticketService.deleteByPerformId(delId);

        if (delNum == 0) {
            finalJson.addProperty("errorMsg", "删除失败");
        }

        finalJson.addProperty("success", 1);

        return finalJson.toString();
    }
}
