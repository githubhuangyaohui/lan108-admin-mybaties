package com.persistenthuang.lan108admin.mapper;

import com.persistenthuang.lan108admin.pojo.LanAuthor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface LanAuthorMapper{
    List<LanAuthor> selectList(LanAuthor author);
    LanAuthor selectOne(LanAuthor author);
    int insert(LanAuthor lanAuthor); //返回Id
    int update(LanAuthor lanAuthor);
    int delete(LanAuthor lanAuthor);
}
