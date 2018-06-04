package com.Infinity.test;

import com.Infinity.dao.SeatTypeDao;
import com.Infinity.pojo.SeatType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/seatType")
public class SeatTypeDaoTest {

    @Autowired
    SeatTypeDao seatTypeDao;

    @RequestMapping("/selectAll")
    public String selectAll() {

        List<SeatType> list = seatTypeDao.selectAll();
        System.out.println(list);
        return "welcome";
    }

    @RequestMapping("/selectById")
    public String selectById(int id) {

        SeatType seatType = seatTypeDao.selectById(id);
        System.out.println(seatType);

        return "welcome";
    }
}
