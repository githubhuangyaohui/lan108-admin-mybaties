package com.persistenthuang.lan108admin.mapper;

import com.persistenthuang.lan108admin.pojo.LanFocus;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LanFocusMapper{
    int insert(LanFocus focus);
    int delete(LanFocus focus);
    List<LanFocus> selectList(LanFocus focus);
    LanFocus selectOne(LanFocus focus);
}
