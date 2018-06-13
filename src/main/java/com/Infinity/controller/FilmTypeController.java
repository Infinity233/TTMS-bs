package com.Infinity.controller;

import com.Infinity.pojo.FilmType;
import com.Infinity.service.FilmTypeService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/filmType/")
public class FilmTypeController {
    
    @Autowired
    FilmTypeService filmTypeService;
    
    @RequestMapping("selectAll")
    public String selectAll() {

        Gson gson = new Gson();
        JsonObject finalJson = new JsonObject();

        List<FilmType> filmTypes = filmTypeService.selectAll();

        finalJson.add("filmTypeList", gson.toJsonTree(filmTypes));
        return finalJson.toString();
    }
}
