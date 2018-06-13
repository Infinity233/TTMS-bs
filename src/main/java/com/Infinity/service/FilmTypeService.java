package com.Infinity.service;

import com.Infinity.dao.FilmTypeMapper;
import com.Infinity.pojo.FilmType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmTypeService {

    @Autowired
    FilmTypeMapper filmTypeMapper;

    public List<FilmType> selectAll() {
        return filmTypeMapper.selectAll();
    }

}
