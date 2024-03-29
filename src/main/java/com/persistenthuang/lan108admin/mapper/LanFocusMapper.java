package com.persistenthuang.lan108admin.mapper;

import com.persistenthuang.lan108admin.pojo.LanFocus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LanFocusMapper{
    int insert(@Param("focus") LanFocus focus);
    int delete(@Param("focus")LanFocus focus);
    List<LanFocus> selectList(@Param("focus")LanFocus focus);
    LanFocus selectOne(@Param("focus")LanFocus focus);
}
