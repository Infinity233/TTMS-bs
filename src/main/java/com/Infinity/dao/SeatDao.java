package com.Infinity.dao;

import com.Infinity.pojo.Seat;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatDao {

    int insertSeat(Seat seat);

    int deleteSeat(int seatId);

    int deleteSeats(List<Integer> delIds);

    int updateSeat(Seat seat);

    List<Seat> selectAllSeat();

    Seat selectById(int id);
}
