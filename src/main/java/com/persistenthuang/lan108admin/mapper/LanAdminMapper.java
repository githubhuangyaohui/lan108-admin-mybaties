package com.persistenthuang.lan108admin.mapper;

import com.persistenthuang.lan108admin.pojo.LanAdmin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LanAdminMapper{
    //查
    List<LanAdmin> selectList(@Param("admin") LanAdmin admin);
    LanAdmin selectOne(@Param("admin")LanAdmin admin);
    //增
    int insert(@Param("admin")LanAdmin admin);
    //删
    int delete(@Param("admin")LanAdmin admin);
    //改
    int update(@Param("admin")LanAdmin admin);
}
