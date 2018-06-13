package com.Infinity.dao;

import com.Infinity.pojo.Ticket;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TicketMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Ticket record);

    int insertSelective(Ticket record);

    Ticket selectByPrimaryKey(Integer id);

    List<Ticket> selectSoldedByPerformId(Integer performId);

    int updateByPrimaryKeySelective(Ticket record);

    int updateByPrimaryKey(Ticket record);

    int deleteByPerformId(String[] studioId);

    int updateTicketStatus(@Param("ticket") Ticket ticket);
}