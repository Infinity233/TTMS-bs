package com.Infinity.dao;

import com.Infinity.pojo.Perform;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerformMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Perform record);

    int insertSelective(Perform record);

    Perform selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Perform record);

    int updateByPrimaryKey(Perform record);

    List<Perform> selectAll();

    List<Perform> selectByFilmId(Integer id);

    int deleteByIds(String[] delIds);
}