package com.Infinity.dao;

import com.Infinity.pojo.Seat;

import java.util.List;

public interface SeatMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Seat record);

    int insertSelective(Seat record);

    Seat selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Seat record);

    int updateByPrimaryKey(Seat record);

    List<Seat> selectAll();
}