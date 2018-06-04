package com.Infinity.test;

import com.Infinity.dao.SeatDao;
import com.Infinity.pojo.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/test")
public class Main {

    @Autowired
    SeatDao seatDao;

    @RequestMapping("/seatDao")
    public String testSeatDao() {

//        Studio studio = new Studio();
//        studio.setStudioId(3);
//
//        SeatType seatType = new SeatType();
//        seatType.setId(2);
//
//        Seat seat = new Seat(9,2,seatType,studio);
//        seat.setSeatId(2);

        List<Seat> list = seatDao.selectAllSeat();

        for(Seat s:list){
            System.out.println(s);
        }

        return "welcome";
    }
}
