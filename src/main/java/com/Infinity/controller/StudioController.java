package com.Infinity.controller;

import com.Infinity.pojo.Studio;
import com.Infinity.service.SeatService;
import com.Infinity.service.StudioService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/studio/")
public class StudioController {

    @Autowired
    StudioService studioService;

    @Autowired
    SeatService seatService;

    @RequestMapping("selectAll")
    public String selectAll() {

        Gson gson = new Gson();
        JsonObject finalJson = new JsonObject();
        JsonArray jsonArray = new JsonArray();

        finalJson.addProperty("code", 0);
        finalJson.addProperty("msg", "");

        List<Studio> studios = studioService.selectAll();

        finalJson.addProperty("count", studios.size());

        for (Studio studio : studios) {
            jsonArray.add(gson.toJsonTree(studio));
        }

        finalJson.add("data", jsonArray);
        return finalJson.toString();
    }

//    @RequestMapping("/selectByStudioName")
//    public String selectByStudioname(String studioname) {
//
//        if (studioname == null || studioname.equals("")) {
//            return selectAll();
//        }
//
//        Gson gson = new Gson();
//        JsonObject finalJson = new JsonObject();
//        JsonArray jsonArray = new JsonArray();
//
//        Studio studio = new Studio();
//        studio.setStudioname(studioname);
//
//        finalJson.addProperty("code", 0);
//        finalJson.addProperty("msg", "");
//
//        List<Studio> studios = studioService.serachStudio(studioname);
//
//        finalJson.addProperty("count", studios.size());
//
//        for (Studio tStudio : studios) {
//            jsonArray.add(gson.toJsonTree(tStudio));
//        }
//
//        finalJson.add("data", jsonArray);
//        return finalJson.toString();
//    }

    @RequestMapping("delete")
    public String delStudios(String delIds) {

        JsonObject finalJson = new JsonObject();

        String[] delId = delIds.split(",");

        int delNum = studioService.delete(delId);

        if (delNum == 0) {
            finalJson.addProperty("errorMsg", "删除失败");
        }

        finalJson.addProperty("success", 1);

        return finalJson.toString();
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String addStudio(Studio studio) {

        JsonObject finalJson = new JsonObject();

        String errorMsg = null;

        int resultNum = 0;

        if (studio.getId() == null) {
            // add
            resultNum = studioService.insert(studio);
            seatService.insertByStudio(studio.getWidth(), studio.getLength(), studio.getId());


        } else {
            // update
            resultNum = studioService.update(studio);
        }

        if (resultNum == 0) {
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
