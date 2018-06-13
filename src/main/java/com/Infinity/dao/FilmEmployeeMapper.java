package com.Infinity.dao;

import com.Infinity.pojo.FilmEmployee;

public interface FilmEmployeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FilmEmployee record);

    int insertSelective(FilmEmployee record);

    FilmEmployee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FilmEmployee record);

    int updateByPrimaryKey(FilmEmployee record);

    int deleteByFilmId(String[] filmIds);
}