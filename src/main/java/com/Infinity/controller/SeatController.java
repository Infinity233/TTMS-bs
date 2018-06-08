package com.Infinity.controller;

import com.Infinity.pojo.Seat;
import com.Infinity.service.SeatService;
import com.Infinity.util.StringUtil;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/seat/")
public class SeatController {

    @Autowired
    SeatService seatService;

    @RequestMapping("selectAll")
    public String selectAll() {

        Gson gson = new Gson();
        JsonObject finalJson = new JsonObject();
        JsonArray tempArray = new JsonArray();

        finalJson.addProperty("code", 0);
        finalJson.addProperty("msg", "");

        List<Seat> seats = seatService.selectAll();

        finalJson.addProperty("count", seats.size());

        finalJson.add("data", gson.toJsonTree(seats));

        return finalJson.toString();
    }

    @RequestMapping("setSeats")
    public String setSeats(String toUn, String toAv, Integer studioId) {

        if (StringUtil.isNotEmpty(toUn)) {
            String[] setUn = toUn.split(",");
            System.out.println(seatService.setUn(setUn, studioId));
        }
        if (StringUtil.isNotEmpty(toAv)) {
            String[] setAv = toAv.split(",");
            System.out.println(seatService.setAv(setAv, studioId));
        }

        return null;
    }
}
