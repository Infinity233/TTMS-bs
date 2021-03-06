package com.Infinity.dao;

import com.Infinity.pojo.Seat;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SeatMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByStudioId(String[] studioId);

    int insert(Seat record);

    int insertSelective(Seat record);

    Seat selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Seat record);

    int updateByPrimaryKey(Seat record);

    int updateByRowCol(Seat record);

    List<Seat> selectAll();

    List<Seat> selectByStudioId(Integer studioId);
}