package com.example.dao;

import com.example.entity.user;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import tk.mybatis.mapper.common.Mapper;

@Repository
public interface UserDao extends Mapper<user> {

    @Select("select * from user")
    List<user> getUser();
}
