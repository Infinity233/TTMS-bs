package com.Infinity.test;

import com.Infinity.dao.FilmMapper;
import com.Infinity.pojo.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/film")
public class FilmMapperTest {

    @Autowired
    FilmMapper filmMapper;

    @RequestMapping("/selectall")
    public String selectAll() {

        List<Film> list = filmMapper.selectAll();

        for (Film film : list) {
            System.out.println(film);
        }

        return "welcome";
    }

    @RequestMapping("/selectById")
    public String selectById(int id) {

        Film film = filmMapper.selectByPrimaryKey(id);
        System.out.println(film);

        return "welcome";
    }
}
