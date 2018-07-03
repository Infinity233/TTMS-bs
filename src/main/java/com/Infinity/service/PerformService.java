package com.Infinity.service;

import com.Infinity.dao.PerformMapper;
import com.Infinity.pojo.Perform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformService {

    @Autowired
    PerformMapper performMapper;

    public List<Perform> selectAll() {

        return performMapper.selectAll();
    }

    public List<Perform> selectByFilmId(Integer id) {
        return performMapper.selectByFilmId(id);
    }
    public int insert(Perform perform) {
        
        return performMapper.insert(perform);
    }

    public int update(Perform perform) {

        return performMapper.updateByPrimaryKeySelective(perform);
    }

    public int delete(String[] list) {

        int delNum = performMapper.deleteByIds(list);
        return delNum;
    }
}
