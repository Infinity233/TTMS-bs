package com.Infinity.dao;

import com.Infinity.pojo.Employee;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    @Select("select * from t_employee")
    List<Employee> selectAll();

    @Select("select * from t_employee em where id in (select employeeId from t_film_employee where filmId = #{id})")
    List<Employee> selectByFilmId(int id);

    @Select("select id from t_employee where name = #{name}")
    Integer selectByname(String name);
}