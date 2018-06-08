package com.Infinity.test;

import com.Infinity.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seatTest/")
public class Seattest {

    @Autowired
    SeatService seatService;

    @RequestMapping("test")
    public void test(String ids) {
        seatService.deleteByStudioId(ids.split(","));
    }
}
