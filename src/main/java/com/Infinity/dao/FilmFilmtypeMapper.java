package com.Infinity.dao;

import com.Infinity.pojo.FilmFilmtype;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmFilmtypeMapper {
    int deleteByPrimaryKey(Integer id);

    FilmFilmtype selectByPrimaryKey(Integer id);

    int insertByFilmIdTypeId(@Param("filmId") Integer filmId,@Param("typeId") Integer typeId);

    int deleteByFilmId(String[] filmIds);
}