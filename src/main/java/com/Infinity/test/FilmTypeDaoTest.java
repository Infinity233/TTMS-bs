package com.Infinity.test;

import com.Infinity.dao.FilmTypeDao;
import com.Infinity.pojo.FilmType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/FilmType")
public class FilmTypeDaoTest {

    @Autowired
    FilmTypeDao filmTypeDao;

    @RequestMapping("/selectById")
    public String selectByPrimaryKey(Integer id) {

        System.out.println(filmTypeDao.selectByPrimaryKey(id));

        return "welcome";
    }

    @RequestMapping("/selectAll")
    public String selectAll() {

        System.out.println(filmTypeDao.selectAll());

        return "welcome";
    }

    @RequestMapping("/insert")
    public String insert(String desc) {

        FilmType filmType = new FilmType(desc);

        System.out.println(filmTypeDao.insert(filmType));

        return "welcome";
    }

    @RequestMapping("/deleteById")
    public String delete(int id) {

        System.out.println(filmTypeDao.deleteByPrimaryKey(id));

        return "welcome";
    }
}
