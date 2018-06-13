package com.Infinity.service;

import com.Infinity.dao.EmployeeMapper;
import com.Infinity.dao.FilmEmployeeMapper;
import com.Infinity.dao.FilmFilmtypeMapper;
import com.Infinity.dao.FilmMapper;
import com.Infinity.pojo.Employee;
import com.Infinity.pojo.Film;
import com.Infinity.pojo.FilmEmployee;
import com.Infinity.pojo.FilmType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    @Autowired
    FilmMapper filmMapper;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    FilmFilmtypeMapper filmtypeMapper;

    @Autowired
    FilmEmployeeMapper filmEmployeeMapper;

    public List<Film> selectAll() {

        return filmMapper.selectAll();
    }

    public List<Film> selectHotFilm() {

        return filmMapper.selectHotFilm();
    }

    public List<Film> selectThreeNew() {
        return filmMapper.selectLastestThree();
    }

    public List<Film> serachFilm(String filmname) {

        List<Film> list = filmMapper.selectByFilmnameMohu(filmname);
        return list;
    }

    public Film selectById(Integer id) {
        return filmMapper.selectByPrimaryKey(id);
    }

    public int insert(Film film, String typenId, String employees) {

        int addNum = filmMapper.insertSelective(film);

        Integer typenums = Integer.parseInt(typenId);

        filmtypeMapper.insertByFilmIdTypeId(film.getId(), typenums);

        String[] employeeArr = employees.split("、");

        for (String emName : employeeArr) {
            int t = employeeService.getEmployeePrimaryKey(emName);
            filmEmployeeMapper.insert(new FilmEmployee(film.getId(), t));
        }

        return addNum;
    }

    public int update(Film film, String typenId, String employees) {

        int updNum = filmMapper.updateByPrimaryKeySelective(film);

        filmtypeMapper.deleteByFilmId(new String[]{film.getId().toString()});
        Integer typenums = Integer.parseInt(typenId);
        filmtypeMapper.insertByFilmIdTypeId(film.getId(), typenums);

        filmEmployeeMapper.deleteByFilmId(new String[]{film.getId().toString()});

        String[] employeeArr = employees.split("、");

        for (String emName : employeeArr) {
            int t = employeeService.getEmployeePrimaryKey(emName);
            filmEmployeeMapper.insert(new FilmEmployee(film.getId(), t));
        }

        return updNum;
    }

    public int delete(String[] list) {

        int delNum = filmMapper.deleteByIds(list);

        filmtypeMapper.deleteByFilmId(list);

        filmEmployeeMapper.deleteByFilmId(list);

        return delNum;
    }

    public String getImagePath(Integer id) {

        return filmMapper.getImagePathById(id);
    }
}
