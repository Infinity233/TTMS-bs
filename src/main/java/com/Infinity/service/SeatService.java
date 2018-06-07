package com.Infinity.service;

import com.Infinity.dao.SeatMapper;
import com.Infinity.pojo.Seat;
import com.Infinity.pojo.SeatType;
import com.Infinity.pojo.Studio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    @Autowired
    SeatMapper seatMapper;

    public List<Seat> selectAll() {

        return seatMapper.selectAll();
    }

//    public List<Seat> serachSeat(String seatname) {
//
//        List<Seat> list = seatMapper.selectBySeatnameMohu(seatname);
//        return list;
//    }

    public int insert(Seat seat) {

        return seatMapper.insert(seat);
    }

    public int update(Seat seat) {

        return seatMapper.updateByPrimaryKeySelective(seat);
    }

    public int insertByStudio(int row, int col, int studioId) {

        Studio studioTemplate = new Studio();
        SeatType seatTypeTemplate = new SeatType();
        Seat seatTemplate = new Seat();

        studioTemplate.setId(studioId);
        seatTypeTemplate.setId(1);

        seatTemplate.setStudio(studioTemplate);
        seatTemplate.setSeatType(seatTypeTemplate);

        int sum = 0;

        for (int i = 1; i <= row; ++i) {
            for (int j = 1; j <= col; ++j) {
                seatTemplate.setRow(i);
                seatTemplate.setCol(j);

                sum += seatMapper.insert(seatTemplate);
            }
        }
        return sum;
    }
}
