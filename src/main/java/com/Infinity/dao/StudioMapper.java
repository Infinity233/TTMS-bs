package com.Infinity.dao;

import com.Infinity.pojo.Studio;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudioMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Studio record);

    int insertSelective(Studio record);

    Studio selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Studio record);

    int updateByPrimaryKey(Studio record);

    @Select("select * from t_studio")
    List<Studio> selectAll();

    int deleteByIds(String[] delIds);
}