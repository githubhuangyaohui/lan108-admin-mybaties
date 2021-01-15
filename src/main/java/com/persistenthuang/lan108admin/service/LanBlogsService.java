package com.persistenthuang.lan108admin.service;

import com.persistenthuang.lan108admin.pojo.LanBlogs;

import java.util.List;

public interface LanBlogsService {
    //获取博客全部信息
    LanBlogs selectBlog(int id);
    List<LanBlogs> SearchBlog(String keywords);
    List<LanBlogs> selectFocusMassage(int userID);
    //基础操作
    int insertBlogs(LanBlogs lanBlogs);
    int deleteBlogs(LanBlogs lanBlogs);
    int updateBlogs(LanBlogs blogs);
    List<LanBlogs> selectBlogs(LanBlogs lanBlogs,int currentPage, int size);
    LanBlogs selectBlogsOne(LanBlogs lanBlogs);
    //获取文章分类
    int getBlogRoleIdByBlogId(int BlogId);

}
