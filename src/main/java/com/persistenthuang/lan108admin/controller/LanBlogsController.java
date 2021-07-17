package com.persistenthuang.lan108admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.persistenthuang.lan108admin.Result.ResuleMessage;
import com.persistenthuang.lan108admin.Result.Result;
import com.persistenthuang.lan108admin.config.BlogStatus;
import com.persistenthuang.lan108admin.pojo.LanBlogs;
import com.persistenthuang.lan108admin.pojo.LanFocus;
import com.persistenthuang.lan108admin.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 发表文章控制类
 */
@Slf4j
@Controller
public class LanBlogsController {
    @Autowired
    LanBlogsServiceImpl lanBlogsService;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    LanAdminServiceImpl lanAdminService;

    @Autowired
    LanFocusServiceImpl lanFocusService;

    @Autowired
    LanMassageServiceImpl lanMassageService;

    // 首页推荐文章列表
    @CrossOrigin
    @RequestMapping("/api/user/homeBlogList")
    @ResponseBody
        public String getHomeBlog(@RequestBody JSONObject jsonObject) {
        log.info(jsonObject.toString());
        int currentPage = jsonObject.getInteger("currentPage");
        int size= jsonObject.getInteger("size");
        //设置文章查找条件
        LanBlogs blogs=new LanBlogs();
        blogs.setBlogsStatus(BlogStatus.SUCCESS);
        List<LanBlogs> lanBlogs = lanBlogsService.selectBlogs(blogs,currentPage, size);
        log.info(JSONObject.toJSONString(lanBlogs));
        return JSONObject.toJSONString(lanBlogs);
    }

    // 首页置顶文章文章列表
    @CrossOrigin
    @RequestMapping("/api/user/homeBlogFirstList")
    @ResponseBody
    public String getHomeBlogFirst(@RequestBody JSONObject jsonObject) {
        log.info(jsonObject.toString());
        int currentPage = jsonObject.getInteger("currentPage");
        int size= jsonObject.getInteger("size");
        LanBlogs blogs=new LanBlogs();
        blogs.setBlogsStatus(BlogStatus.FIRST);
        List<LanBlogs> lanBlogs = lanBlogsService.selectBlogs(blogs,currentPage,size);
        log.info(JSONObject.toJSONString(lanBlogs));
        return JSONObject.toJSONString(lanBlogs);
    }

    // 通过id获取文章详细信息
    @CrossOrigin
    @RequestMapping("/api/user/blogMassage")
    @ResponseBody
    public String getBlogMassage(@RequestBody JSONObject jsonObject) {
        Integer blogId = jsonObject.getInteger("blogId");
        log.info("获取文章具体信息");
        LanBlogs blog = lanBlogsService.selectBlog(blogId);
        log.info("获取的文章信息：" + blog.toString());
        return JSONObject.toJSONString(blog);
    }

    // 通过关键词搜索blog
    @CrossOrigin
    @RequestMapping("/api/search")
    @ResponseBody
    public String selectByKeywords(@RequestBody JSONObject jsonObject)
    {
        String keywords = jsonObject.getString("key");
        log.info("查找关键词:" + keywords);
        // 关键词为空时查询出所有书籍
        List<LanBlogs> lanBlogs;
        if ("".equals(keywords)) {
            lanBlogs = null;
        } else {
            lanBlogs = lanBlogsService.SearchBlog(keywords);
        }
        return JSONObject.toJSONString(lanBlogs);
    }

    // 获取专栏文章列表
    @CrossOrigin
    @RequestMapping("/api/user/rolesBlog")
    @ResponseBody
    public String getRoleBlogs(@RequestBody JSONObject jsonObject) {
        int rolesId = jsonObject.getInteger("rolesId");
        int currentPage = jsonObject.getInteger("currentPage");
        int size= jsonObject.getInteger("size");
        //构建参数
        LanBlogs blogs=new LanBlogs();
        blogs.setBlogsColumn(rolesId);
        blogs.setBlogsStatus(BlogStatus.SUCCESS);
        //参数
        List<LanBlogs> roleBlogs = this.lanBlogsService.selectBlogs(blogs,currentPage,size);
        log.info("获取专栏文章列表:" + roleBlogs.toString());
        return JSONObject.toJSONString(roleBlogs);
    }

    // 获取个人中心文章列表
    @CrossOrigin
    @RequestMapping("/api/user/authorBlogList/Uid")
    @ResponseBody
    public String getAdminBlogs(@RequestBody JSONObject jsonObject) {
        int userId = jsonObject.getInteger("userId");
        int currentPage = jsonObject.getInteger("currentPage");
        int size= jsonObject.getInteger("size");
        int authorID = this.userService.getAuthorID(userId);
        //构建参数
        LanBlogs blogs=new LanBlogs();
        blogs.setBlogsAuthorId(authorID);
        blogs.setBlogsStatus(BlogStatus.SUCCESS);
        //查找
        List<LanBlogs> roleBlogs = this.lanBlogsService.selectBlogs(blogs,currentPage,size);
        log.info("获取个人中心文章列表:" + roleBlogs.toString());
        return JSONObject.toJSONString(roleBlogs);
    }

    // 获取作者文章列表
    @CrossOrigin
    @RequestMapping("/api/user/authorBlogList/Aid")
    @ResponseBody
    public String getAuthorBlogs(@RequestBody JSONObject jsonObject) {
        int authorId= jsonObject.getInteger("authorId");
        int currentPage = jsonObject.getInteger("currentPage");
        int size= jsonObject.getInteger("size");
        //构建参数
        LanBlogs blogs=new LanBlogs();
        blogs.setBlogsAuthorId(authorId);
        blogs.setBlogsStatus(BlogStatus.SUCCESS);
        //查找
        List<LanBlogs> roleBlogs = this.lanBlogsService.selectBlogs(blogs,currentPage,size);
        return JSONObject.toJSONString(roleBlogs);
    }

    //----------------------------------------------------------------------------------------

    /**
     * 根据作者id返回作者草稿
     */

    @CrossOrigin
    @RequestMapping("/api/editor/blogTempList/Aid")
    @ResponseBody
    public String CreateList(@RequestBody JSONObject jsonObject) {
        int userAuthorId = jsonObject.getInteger("authorId");
        int currentPage = jsonObject.getInteger("currentPage");
        int size= jsonObject.getInteger("size");
        //构建参数
        LanBlogs blogs=new LanBlogs();
        blogs.setBlogsAuthorId(userAuthorId);
        blogs.setBlogsStatus(BlogStatus.TEMP);
        //查找
        List<LanBlogs> lanBlogsTemps = lanBlogsService.selectBlogs(blogs,currentPage,size);
        log.info("创建博客草稿列表" + lanBlogsTemps.toString());
        return JSONObject.toJSONString(lanBlogsTemps);
    }

    /**
     * 返回编辑文字内容
     */
    @CrossOrigin
    @RequestMapping("/api/editor/blogTempCard")
    @ResponseBody
    public String editorTempBlog(@RequestBody JSONObject jsonObject) {
        int id = jsonObject.getInteger("blogTempId");
        //构建参数
        LanBlogs blogs=new LanBlogs();
        blogs.setId(id);
        blogs.setBlogsStatus(BlogStatus.TEMP);
        //查找
        LanBlogs lanBlogsTemp = lanBlogsService.selectBlogsOne(blogs);
        log.info("预览博客信息:" + lanBlogsTemp.toString());
        return JSONObject.toJSONString(lanBlogsTemp);
    }

    /**
     * 根据作者id和文章id删除文章
     */
    @CrossOrigin
    @RequestMapping("/api/editor/deleteBlogTemp")
    @ResponseBody
    public String blogTempDelete(@RequestBody JSONObject jsonObject) {
        //获取前端信息
        int userId = jsonObject.getInteger("userId");
        int blogTempId = jsonObject.getInteger("blogTempId");
        //获取作者id
        int authorId = userService.getAuthorID(userId);
        //构建参数
        LanBlogs lanBlogsTemp = new LanBlogs();
        lanBlogsTemp.setId(blogTempId);
        lanBlogsTemp.setBlogsAuthorId(authorId);
        //删除文章
        int num = lanBlogsService.deleteBlogs(lanBlogsTemp);
        if (num == 0) {
            return JSONObject.toJSONString(new ResuleMessage(Result.FAILURE, "删除失败"));
        } else {
            return JSONObject.toJSONString(new ResuleMessage(Result.SUCCESS, "删除成功"));
        }
    }

    /**
     * 根据作者id返回作者已投稿
     */
    @CrossOrigin
    @RequestMapping("/api/editor/blogSubmitList/Aid ")
    @ResponseBody
    public String CreateListSubmit(@RequestBody JSONObject jsonObject) {
        int userAuthorId = jsonObject.getInteger("authorId");
        int currentPage = jsonObject.getInteger("currentPage");
        int size= jsonObject.getInteger("size");
        //构建参数
        LanBlogs blogs=new LanBlogs();
        blogs.setBlogsAuthorId(userAuthorId);
        blogs.setBlogsStatus(BlogStatus.REVIEW);
        //查找
        List<LanBlogs> lanBlogs = lanBlogsService.selectBlogs(blogs, currentPage, size);
        return JSONObject.toJSONString(lanBlogs);
    }

    /**
     * 根据作者id和文章id撤销投稿
     */
    @CrossOrigin
    @RequestMapping("/api/editor/unSubmit")
    @ResponseBody
    public String blogTempUnSubmit(@RequestBody JSONObject jsonObject) {
        //获取前端信息
        int userId = jsonObject.getInteger("userId");
        int blogTempId = jsonObject.getInteger("blogTempId");
        //获取作者id
        int authorId = userService.getAuthorID(userId);
        //构建参数
        LanBlogs lanBlogs = new LanBlogs();
        lanBlogs.setId(blogTempId);
        lanBlogs.setBlogsAuthorId(authorId);
        lanBlogs.setBlogsStatus(BlogStatus.TEMP);
        int i = lanBlogsService.updateBlogs(lanBlogs);
        if (i == 0) {
            return JSONObject.toJSONString(new ResuleMessage(Result.FAILURE, "撤销失败"));
        } else {
            return JSONObject.toJSONString(new ResuleMessage(Result.SUCCESS, "撤销成功"));

        }
    }

    /**
     * 投稿文章
     */
    @CrossOrigin
    @RequestMapping("/api/editor/submit")
    @ResponseBody
    public String publishedArticle(@RequestBody JSONObject jsonObject) {
        int blogTempId = jsonObject.getInteger("blogId");
        log.info("发布文章ID:" + blogTempId);
        //构建参数
        LanBlogs lanBlogs = new LanBlogs();
        lanBlogs.setId(blogTempId);
        lanBlogs.setBlogsStatus(BlogStatus.REVIEW);
        //更改博客状态
        lanBlogsService.updateBlogs(lanBlogs);
        return JSONObject.toJSONString(new ResuleMessage(Result.SUCCESS, "投稿成功"));
    }

    /**
     * 保存草稿
     */
    @CrossOrigin
    @RequestMapping("/api/editor/saveArticle")
    @ResponseBody
    public String SaveBlog(@RequestBody JSONObject jsonObject) {
        log.info("************保存博客************");
        log.info("文章前端传回字符串:" + jsonObject.toJSONString());
        int id = jsonObject.getInteger("id");
        int blogsAuthorId = jsonObject.getInteger("blogsAuthorId");
        String blogsTitle = jsonObject.getString("blogsTitle");
        String blogsContent = jsonObject.getString("blogsContent");
            String blogsHtml = jsonObject.getString("blogsHtml");
        String blogsSummary = jsonObject.getString("blogsSummary");
        String blogsCover = jsonObject.getString("blogsCover");
        int blogsColumn = jsonObject.getInteger("blogsColumn");

        LanBlogs lanBlogsTemp = new LanBlogs();
        lanBlogsTemp.setBlogsAuthorId(blogsAuthorId);
        lanBlogsTemp.setBlogsTitle(blogsTitle);
        lanBlogsTemp.setBlogsContent(blogsContent);
        lanBlogsTemp.setBlogsHtml(blogsHtml);
        lanBlogsTemp.setBlogsCover(blogsCover);
        lanBlogsTemp.setBlogsSummary(blogsSummary);
        lanBlogsTemp.setBlogsColumn(blogsColumn);
        if (id == 0) {
            log.info("新建博客" + lanBlogsTemp.toString());
            lanBlogsService.insertBlogs(lanBlogsTemp);
        } else {
            log.info("修改博客");
            lanBlogsTemp.setId(id);
            lanBlogsService.updateBlogs(lanBlogsTemp);
        }
        return JSONObject.toJSONString(lanBlogsTemp.getId());
    }

    /**
     * 管理员返回提交的博客列表
     */
    @CrossOrigin
    @RequestMapping("/api/admin/submitBlog")
    @ResponseBody
    public String getsubmitBlogs(@RequestBody JSONObject jsonObject) {
        int userID = jsonObject.getInteger("userId");
        int currentPage = jsonObject.getInteger("currentPage");
        int size= jsonObject.getInteger("size");

        int roleId = lanAdminService.getRoleIdByUserId(userID);
        //构建参数
        LanBlogs blogs = new LanBlogs();
        blogs.setBlogsColumn(roleId);
        blogs.setBlogsStatus(BlogStatus.REVIEW);

        List<LanBlogs> submitBlogs = lanBlogsService.selectBlogs(blogs,currentPage,size);
        log.info("投稿的专栏信息" + submitBlogs.toString());
        return JSONObject.toJSONString(submitBlogs);
    }

    /**
     * 管理员返回通过的专栏列表
     */
    @CrossOrigin
    @RequestMapping("/api/admin/passBlog")
    @ResponseBody
    public String getPassedBlogList(@RequestBody JSONObject jsonObject) {
        int userId = jsonObject.getInteger("userId");
        int currentPage = jsonObject.getInteger("currentPage");
        int size= jsonObject.getInteger("size");
        int roleID = lanAdminService.getRoleIdByUserId(userId);
        //构建参数
        LanBlogs blogs = new LanBlogs();
        blogs.setBlogsColumn(roleID);
        blogs.setBlogsStatus(BlogStatus.SUCCESS);
        //查找
        List<LanBlogs> passBlogs = lanBlogsService.selectBlogs(blogs,currentPage,size);
        log.info("通过文章列表" + passBlogs.toString());
        return JSONObject.toJSONString(passBlogs);
    }

    /**
     * 管理员返回不通过的列表
     */
    @CrossOrigin
    @RequestMapping("/api/admin/unPassBlog")
    @ResponseBody
    public String getUnPassedBlogList(@RequestBody JSONObject jsonObject) {
        int userId = jsonObject.getInteger("userId");
        int currentPage = jsonObject.getInteger("currentPage");
        int size= jsonObject.getInteger("size");
        int roleID = lanAdminService.getRoleIdByUserId(userId);
        //构建参数
        LanBlogs blogs = new LanBlogs();
        blogs.setBlogsColumn(roleID);
        blogs.setBlogsStatus(BlogStatus.FIRST);
        //查找
        List<LanBlogs> unPassBlogs = lanBlogsService.selectBlogs(blogs,currentPage,size);
        log.info("没有通过的博客列表:" + unPassBlogs.toString());
        return JSONObject.toJSONString(unPassBlogs);
    }

    /**
     * 预览blogsTemp信息
     */
    @CrossOrigin
    @RequestMapping("/api/admin/blogTempCard")
    @ResponseBody
    public String getViewBlogsMessage(@RequestBody JSONObject jsonObject) {
        int id = jsonObject.getInteger("id");
        LanBlogs lanBlogsTemp = lanBlogsService.selectBlog(id);
        log.info("预览博客信息:" + lanBlogsTemp.toString());
        return JSONObject.toJSONString(lanBlogsTemp);
    }

    /**
     * 管理员通过博客，并发布到专栏
     */
    @CrossOrigin
    @RequestMapping("/api/admin/publicBlog")
    @ResponseBody
    public String publicBlogs(@RequestBody JSONObject jsonObject) {
        int userId = jsonObject.getInteger("userId");
        int blogsId = jsonObject.getInteger("blogTempId");
        int roleID = lanAdminService.getRoleIdByUserId(userId);
        if (roleID != 0) {
            //更新为已提交
            LanBlogs blogs=new LanBlogs();
            blogs.setId(blogsId);
            blogs.setBlogsStatus(BlogStatus.SUCCESS);
            lanBlogsService.updateBlogs(blogs);
            if (blogsId != 0) {
                int roleId = lanBlogsService.getBlogRoleIdByBlogId(blogsId);
                List<LanFocus> focusUser = lanFocusService.getFocusUserByRoleId(roleId);
                for (int i = 0; i < focusUser.size(); i++) {
                    int focusUserId = focusUser.get(i).getUserId();
                    log.info("推送关注消息:" + blogsId + focusUserId);
                    lanMassageService.sendMessage(focusUserId, blogsId);
                }
                return JSONObject.toJSONString(new ResuleMessage(Result.SUCCESS, "发布成功"));
            } else {
                return JSONObject.toJSONString(new ResuleMessage(Result.FAILURE, "发布失败"));
            }
        } else {
            return JSONObject.toJSONString(new ResuleMessage(Result.FAILURE, "发布失败"));
        }
    }

    /**
     * 提交不通过请求
     */
    @CrossOrigin
    @RequestMapping("/api/admin/unPublicBlog")
    @ResponseBody
    public String UnpassBlogs(@RequestBody JSONObject jsonObject) {
        int userId = jsonObject.getInteger("userId");
        int blogsTempId = jsonObject.getInteger("blogTempId");
        int roleID = lanAdminService.getRoleIdByUserId(userId);
        if (roleID != 0) {
            //构建参数
            LanBlogs blogs= new LanBlogs();
            blogs.setId(blogsTempId);
            blogs.setBlogsStatus(BlogStatus.FAIL);
            lanBlogsService.updateBlogs(blogs);
            log.info("提交不通过请求：成功");
            return JSONObject.toJSONString(new ResuleMessage(Result.SUCCESS, "提交不通过请求：成功"));
        } else {
            log.info("提交不通过请求：失败");
            return JSONObject.toJSONString(new ResuleMessage(Result.FAILURE, "提交不通过请求：失败"));
        }
    }
}
