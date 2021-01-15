package com.persistenthuang.lan108admin.mapper;

import com.persistenthuang.lan108admin.pojo.LanMassage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LanMassageMapper{
    int update(LanMassage massage);
    int insert(LanMassage massage);
    int delete(LanMassage massage);
    List<LanMassage> selectList(LanMassage massage);
}
