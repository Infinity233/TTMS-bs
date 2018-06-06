package com.Infinity.dao;

import com.Infinity.pojo.Perform;

public interface PerformMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Perform record);

    int insertSelective(Perform record);

    Perform selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Perform record);

    int updateByPrimaryKey(Perform record);
}