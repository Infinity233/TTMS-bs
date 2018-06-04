package com.Infinity.dao;

import com.Infinity.pojo.SeatType;

import java.util.List;

public interface SeatTypeDao {

    SeatType selectById(Integer id);

    List<SeatType> selectAll();
}
