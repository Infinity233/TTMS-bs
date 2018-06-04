package com.Infinity.dao;

import com.Infinity.pojo.Studio;

import java.util.List;

public interface StudioDao {

    int insertStudio(Studio studio);

    int deleteStudio(Integer stuId);

    int deleteStudios(List<Integer> delIds);

    int updateStudio(Studio studio);

    List<Studio> selectAll();

    Studio selectById(Integer id);
}
