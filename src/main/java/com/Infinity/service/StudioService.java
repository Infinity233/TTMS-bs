package com.Infinity.service;

import com.Infinity.dao.StudioMapper;
import com.Infinity.pojo.Studio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudioService {

    @Autowired
    StudioMapper studioMapper;

    public List<Studio> selectAll() {

        return studioMapper.selectAll();
    }

    public int insert(Studio studio) {

        return studioMapper.insert(studio);
    }

    public int update(Studio studio) {

        return studioMapper.updateByPrimaryKeySelective(studio);
    }

    public int delete(String[] list) {

        return studioMapper.deleteByIds(list);
    }
}
