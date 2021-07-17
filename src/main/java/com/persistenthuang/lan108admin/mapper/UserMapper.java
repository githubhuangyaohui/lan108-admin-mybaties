package com.persistenthuang.lan108admin.mapper;


import com.persistenthuang.lan108admin.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper{
    User selectOne(@Param("user") User user);
    int insert(@Param("user")User user);
    int update(@Param("user")User user);
}
