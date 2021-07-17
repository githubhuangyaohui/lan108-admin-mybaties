package com.persistenthuang.lan108admin.service;

import com.persistenthuang.lan108admin.mapper.LanBlogsMapper;
import com.persistenthuang.lan108admin.pojo.LanBlogs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanBlogsServiceImpl implements LanBlogsService {
    @Autowired
    LanBlogsMapper lanBlogsMapper;

    // 通过blog的ID查询全部数据
    @Override
    public LanBlogs selectBlog(int id) {
        LanBlogs blogs = new LanBlogs();
        blogs.setId(id);
        return lanBlogsMapper.selectone(blogs);
    }

    // 关键值查询
    @Override
    public List<LanBlogs> SearchBlog(String keywords) {
        return lanBlogsMapper.selectListByKey(keywords);
    }

    // 根据博客id集合获取博客列表，基本信息
    @Override
    public List<LanBlogs> selectFocusMassage(int userID) {
        try {
            return lanBlogsMapper.selectListByMessage(userID);
        } catch (Exception e) {
            return null;
        }
    }

    // 添加博客
    @Override
    public int insertBlogs(LanBlogs lanBlogs) {
        return lanBlogsMapper.insert(lanBlogs);
    }

    @Override
    public int deleteBlogs(LanBlogs lanBlogs) {
        return lanBlogsMapper.delete(lanBlogs);
    }

    @Override
    public int updateBlogs(LanBlogs blogs) {
        return lanBlogsMapper.update(blogs);
    }

    @Override
    public List<LanBlogs> selectBlogs(LanBlogs lanBlogs, int currentPage, int size) {
        return lanBlogsMapper.selectList(lanBlogs,(currentPage-1)*size,size);
    }

    @Override
    public LanBlogs selectBlogsOne(LanBlogs lanBlogs) {
        return lanBlogsMapper.selectone(lanBlogs);
    }

    // 获取博客所属专栏Id
    @Override
    public int getBlogRoleIdByBlogId(int BlogId) {
        LanBlogs blogs= new LanBlogs();
        blogs.setId(BlogId);
        LanBlogs lanBlogs = lanBlogsMapper.selectone(blogs);
        return lanBlogs.getBlogsColumn();
    }

}
