package com.Infinity.dao;

import com.Infinity.pojo.FilmType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FilmType record);

    int insertSelective(FilmType record);

    FilmType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FilmType record);

    int updateByPrimaryKey(FilmType record);

    @Select("select * from t_filmtype")
    List<FilmType> selectAll();

    List<FilmType> selectByFilmId(int filmId);
}