package com.Infinity.controller;

import com.Infinity.pojo.Employee;
import com.Infinity.pojo.Film;
import com.Infinity.service.EmployeeService;
import com.Infinity.service.FilmService;
import com.Infinity.util.StringUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/film/")
public class FilmController {

    @Autowired
    FilmService filmService;

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("selectAll")
    public String selectAll() {

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .create();
        JsonObject finalJson = new JsonObject();

        List<Film> filmList = filmService.selectAll();

        finalJson.addProperty("code", 0);
        finalJson.addProperty("msg", "");

        finalJson.addProperty("count", filmList.size());

        finalJson.add("data", gson.toJsonTree(filmList));

        return finalJson.toString();
    }

    @RequestMapping("selectById")
    public String selectById(Integer id) {

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .create();
        JsonObject finalJson = new JsonObject();

        Film film = filmService.selectById(id);

        finalJson.add("data", gson.toJsonTree(film));

        return finalJson.toString();
    }

    @RequestMapping("selectToday")
    public String selectToday() {

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .create();
        JsonObject finalJson = new JsonObject();

        List<Film> filmList = filmService.selectThreeNew();

        finalJson.add("data", gson.toJsonTree(filmList));

        return finalJson.toString();
    }

    @RequestMapping("selectByFilmname")
    public String selectByFilmname(String filmname) {

        if (filmname == null || filmname.equals("")) {
            return selectAll();
        }

        Gson gson = new Gson();
        JsonObject finalJson = new JsonObject();

        Film film = new Film();
        film.setName(filmname);

        List<Film> films = filmService.serachFilm(filmname);

        finalJson.addProperty("code", 0);
        finalJson.addProperty("msg", "");
        finalJson.addProperty("count", films.size());
        finalJson.add("data", gson.toJsonTree(films));

        return finalJson.toString();
    }

    @RequestMapping("selectHotFilm")
    public String selectHotFilm() {

        Gson gson = new Gson();
        JsonObject finalJson = new JsonObject();

        List<Film> filmList = filmService.selectHotFilm();

        finalJson.addProperty("code", 0);
        finalJson.addProperty("msg", "");

        finalJson.addProperty("count", filmList.size());

        finalJson.add("data", gson.toJsonTree(filmList));

        return finalJson.toString();
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addFilm(HttpServletRequest request, String filmname, MultipartFile cover, String typeName, Integer duration
            , String employees, String director, Double score, String publishDate) {

        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String basePath = request.getServletContext().getRealPath("/image/");
        String imagePath = basePath + cover.getOriginalFilename();
        Film film = new Film();

        director = StringUtil.handleChinese(director);
        filmname = StringUtil.handleChinese(filmname);
        employees = StringUtil.handleChinese(employees);


        Integer directorId = employeeService.getEmployeePrimaryKey(director);
        Employee dir = new Employee();
        dir.setId(directorId);

        film.setCover("/image/" + cover.getOriginalFilename());
        film.setName(filmname);
        film.setDuration(duration);
        film.setScore(score);
        film.setClickHit(0);
        film.setDirector(dir);

        try {
            film.setPublishDate(sdf.parse(publishDate));
        } catch (ParseException e) {
            System.out.println("字符串转日期失败");
        }

        filmService.insert(film, typeName, employees);
        File desc = new File(imagePath);

        try {
            cover.transferTo(desc);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("保存失败");
        }

        return jsonObject.toString();
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String updateFilm(HttpServletRequest request, Integer id, String filmname, MultipartFile cover, String typeName, Integer duration
            , String employees, String director, Double score, String publishDate) {

        JsonObject jsonObject = new JsonObject();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Film film = new Film();

        director = StringUtil.handleChinese(director);
        filmname = StringUtil.handleChinese(filmname);
        employees = StringUtil.handleChinese(employees);


        Integer directorId = employeeService.getEmployeePrimaryKey(director);
        Employee dir = new Employee();
        dir.setId(directorId);

        film.setId(id);
        film.setName(filmname);
        film.setDuration(duration);
        film.setScore(score);
        film.setClickHit(0);
        film.setDirector(dir);

        // 文件操作
        if (StringUtil.isNotEmpty(cover.getOriginalFilename())) {

            film.setCover("/image/" + cover.getOriginalFilename());
            String basePath = request.getServletContext().getRealPath("/image/");
            String imagePath = basePath + cover.getOriginalFilename();
            String prePath = filmService.getImagePath(film.getId());

            if (prePath != null) {
                prePath = request.getServletContext().getRealPath("/") + prePath;
                File preImageFile = new File(prePath);
                preImageFile.delete();
            }

            File desc = new File(imagePath);
            try {
                cover.transferTo(desc);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("保存失败");
            }
        }

        try {
            film.setPublishDate(sdf.parse(publishDate));
        } catch (ParseException e) {
            System.out.println("字符串转日期失败");
        }

        // 执行更新操作
        filmService.update(film, typeName, employees);
        return jsonObject.toString();
    }

    @RequestMapping("/delete")
    public String delFilms(String delIds) {

        JsonObject finalJson = new JsonObject();

        String[] delId = delIds.split(",");

        int delNum = filmService.delete(delId);

        if (delNum == 0) {
            finalJson.addProperty("errorMsg", "删除失败");
        }

        finalJson.addProperty("success", 1);

        return finalJson.toString();
    }
}
