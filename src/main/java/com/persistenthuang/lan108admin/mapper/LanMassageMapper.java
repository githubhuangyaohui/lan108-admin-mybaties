package com.persistenthuang.lan108admin.mapper;

import com.persistenthuang.lan108admin.pojo.LanMassage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LanMassageMapper{
    int update(@Param("massage") LanMassage massage);
    int insert(@Param("massage")LanMassage massage);
    int delete(@Param("massage")LanMassage massage);
    List<LanMassage> selectList(@Param("massage")LanMassage massage);
}
