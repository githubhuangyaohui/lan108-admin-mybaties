package com.persistenthuang.lan108admin.mapper;


import com.persistenthuang.lan108admin.pojo.LanAd;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LanAdMapper{
    //增
    int insert(LanAd ad);
    //删
    int delete(LanAd ad);
    //改
    int update(LanAd ad);
    //查
    List<LanAd> select();
}
