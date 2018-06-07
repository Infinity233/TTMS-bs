package com.Infinity.dao;

import com.Infinity.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    @Select("select * from t_user where username=#{username} and password=#{password}")
    User login(@Param("username") String username, @Param("password") String password);

    @Select("select * from t_user")
    List<User> selectAll();


    List<User> selectByUsernameMohu(@Param("username") String username);

    @Select("select count(*) from t_user where username=#{username}")
    int selectByUsername(@Param("username") String username);

    int deleteByIds(String[] delIds);
}