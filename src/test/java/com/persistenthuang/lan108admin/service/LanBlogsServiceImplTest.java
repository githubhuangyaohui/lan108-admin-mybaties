package com.persistenthuang.lan108admin.service;

import com.persistenthuang.lan108admin.config.BlogStatus;
import com.persistenthuang.lan108admin.pojo.LanBlogs;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
class LanBlogsServiceImplTest {

    @Autowired
    LanBlogsServiceImpl lanBlogsService;

    @Test
    void selectBlogs() {
        LanBlogs lanBlogs = new LanBlogs();
        lanBlogs.setBlogsStatus(BlogStatus.SUCCESS);
        List<LanBlogs> lanBlogs1 = lanBlogsService.selectBlogs(lanBlogs, 1, 10);
        System.out.println(lanBlogs1);
    }
}