package com.Infinity.dao;

import com.Infinity.pojo.Manager;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Manager record);

    int insertSelective(Manager record);

    Manager selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);

    @Select("select * from t_manager")
    List<Manager> selectAll();

    List<Manager> selectByUsernameMohu(@Param("username") String username);

    @Select("select * from t_manager where username=#{username} and password=#{password}")
    Manager login(@Param("username") String username, @Param("password") String password);

    @Select("select count(*) from t_manager where username=#{username}")
    int selectByUsername(@Param("username") String username);

    int deleteByIds(String[] delIds);
}