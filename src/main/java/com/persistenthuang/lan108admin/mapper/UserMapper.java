package com.persistenthuang.lan108admin.mapper;


import com.persistenthuang.lan108admin.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper{
    User selectOne(User user);
    int insert(User user);
    int update(User user);
}
