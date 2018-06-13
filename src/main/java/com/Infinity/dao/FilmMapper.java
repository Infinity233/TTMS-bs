package com.Infinity.dao;

import com.Infinity.pojo.Film;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Film record);

    int insertSelective(Film record);

    Film selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Film record);

    int updateByPrimaryKeyWithBLOBs(Film record);

    int updateByPrimaryKey(Film record);

    List<Film> selectAll();

    List<Film> selectHotFilm();

    List<Film> selectLastestThree();

    List<Film> selectByFilmnameMohu(@Param("name") String name);

    int deleteByIds(String[] delIds);

    @Select("select cover from t_film where id = #{id}")
    String getImagePathById(Integer id);
}