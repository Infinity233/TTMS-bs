package com.Infinity.service;

import com.Infinity.dao.SeatMapper;
import com.Infinity.dao.StudioMapper;
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
    @Autowired
    StudioMapper studioMapper;

    public List<Seat> selectAll() {

        return seatMapper.selectAll();
    }

    public StringBuilder[] selectByStudioId(Integer studioId) {

        List<Seat> seatList = seatMapper.selectByStudioId(studioId);
        Studio studio = studioMapper.selectByPrimaryKey(studioId);

        StringBuilder[] seatMap = new StringBuilder[studio.getLength()];
        StringBuilder t = new StringBuilder();

        for (Integer i = 0; i < studio.getWidth(); i++) {
            t.append('a');
        }

        String tmplete = t.toString();

        for (int i = 0; i < seatMap.length; i++) {
            seatMap[i] = new StringBuilder(tmplete);
        }

        for (Seat seat : seatList) {
            if (seat.getSeatTypeId() == 3) {
                seatMap[seat.getRow() - 1].setCharAt(seat.getCol() - 1, 'u');
            }
        }

        return seatMap;
    }

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

    public int setUn(String[] unSeats, Integer studioId) {

        Seat seat = new Seat();
        SeatType type = new SeatType();
        Studio studio = new Studio();
        studio.setId(studioId);
        type.setId(3);

        seat.setStudio(studio);
        seat.setSeatType(type);

        int sum = 0;
        for (int i = 0; i < unSeats.length; ++i) {
            seat.setRow(unSeats[i].charAt(0) - '0');
            seat.setCol(unSeats[i].charAt(2) - '0');

            sum += seatMapper.updateByRowCol(seat);
        }
        return sum;
    }

    public int setAv(String[] avSeats, Integer studioId) {

        Seat seat = new Seat();
        SeatType type = new SeatType();
        Studio studio = new Studio();
        studio.setId(studioId);
        type.setId(1);

        seat.setStudio(studio);
        seat.setSeatType(type);

        int sum = 0;
        for (int i = 0; i < avSeats.length; ++i) {
            seat.setRow(avSeats[i].charAt(0) - '0');
            seat.setCol(avSeats[i].charAt(2) - '0');

            sum += seatMapper.updateByRowCol(seat);
        }
        return sum;
    }

    public int deleteByStudioId(String[] studioId) {

        return seatMapper.deleteByStudioId(studioId);
    }
}
