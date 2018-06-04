package com.Infinity.dao;

import com.Infinity.pojo.FilmType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmTypeDao {
    int deleteByPrimaryKey(Integer id);

    int insert(FilmType record);

    int insertSelective(FilmType record);

    FilmType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FilmType record);

    int updateByPrimaryKey(FilmType record);

    List<FilmType> selectAll();
}