package com.persistenthuang.lan108admin.mapper;

import com.persistenthuang.lan108admin.pojo.LanAuthor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface LanAuthorMapper{
    List<LanAuthor> selectList(@Param("author") LanAuthor author);
    LanAuthor selectOne(@Param("author")LanAuthor author);
    int insert(@Param("author")LanAuthor lanAuthor); //返回Id
    int update(@Param("author")LanAuthor lanAuthor);
    int delete(@Param("author")LanAuthor lanAuthor);
}
