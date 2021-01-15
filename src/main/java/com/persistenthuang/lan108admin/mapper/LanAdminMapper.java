package com.persistenthuang.lan108admin.mapper;

import com.persistenthuang.lan108admin.pojo.LanAdmin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LanAdminMapper{
    //查
    List<LanAdmin> selectList(LanAdmin admin);
    LanAdmin selectOne(LanAdmin admin);
    //增
    int insert(LanAdmin admin);
    //删
    int delete(LanAdmin admin);
    //改
    int update(LanAdmin admin);
}
