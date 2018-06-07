package com.Infinity.dao;

import com.Infinity.pojo.SeatType;

public interface SeatTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SeatType record);

    int insertSelective(SeatType record);

    SeatType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SeatType record);

    int updateByPrimaryKey(SeatType record);
}