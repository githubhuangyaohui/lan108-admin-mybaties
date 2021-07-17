package com.persistenthuang.lan108admin.mapper;

import com.persistenthuang.lan108admin.pojo.LanBlogs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LanBlogsMapper{
    List<LanBlogs> selectList(@Param("lanBlogs") LanBlogs blogs, @Param("start")int start, @Param("size")int size);
    LanBlogs selectone(@Param("lanBlogs")LanBlogs blogs);
    //关键词查询
    List<LanBlogs> selectListByKey(@Param("keywords")String keywords);
    //消息连接查询
    List<LanBlogs> selectListByMessage(@Param("userId")int userID);
    int insert(@Param("lanBlogs")LanBlogs lanBlogs); //返回博客Id
    int update(@Param("lanBlogs")LanBlogs lanBlogs);
    int delete(@Param("lanBlogs")LanBlogs lanBlogs);
}
