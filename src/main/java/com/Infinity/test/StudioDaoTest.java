package com.Infinity.test;

import com.Infinity.dao.StudioDao;
import com.Infinity.pojo.Studio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/studio")
public class StudioDaoTest {

    @Autowired
    StudioDao studioDao;

    @RequestMapping("/selectAll")
    public String selectAll() {

        List<Studio> list =  studioDao.selectAll();

        System.out.println(list.toString());

        return "welcome";
    }

    @RequestMapping("/selectById")
    public String selectById(int studioId) {

        Studio s = studioDao.selectById(studioId);

        System.out.println(s);

        return "welcome";
    }

    @RequestMapping("/add")
    public String add(String name, int length, int width) {

        Studio s = new Studio(name, length, width);
        studioDao.insertStudio(s);

        return "welcome";
    }

    @RequestMapping("/update")
    public String update(int id, String name, int length, int width) {

        Studio s = new Studio(name, length, width);
        s.setStudioId(id);
        studioDao.updateStudio(s);

        return "welcome";
    }

    @RequestMapping("/delete")
    public String delete(int id) {

        System.out.println(studioDao.deleteStudio(id));

        return "welcome";
    }

    @RequestMapping("/deletes")
    public String deletes() {

        List<Integer> list = new ArrayList<>();

        list.add(4);
        list.add(5);

        studioDao.deleteStudios(list);

        return "welcome";
    }
}
