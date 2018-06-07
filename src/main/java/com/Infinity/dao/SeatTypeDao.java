package com.Infinity.dao;

import com.Infinity.pojo.SeatType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatTypeDao {

    SeatType selectById(Integer id);

    List<SeatType> selectAll();
}
