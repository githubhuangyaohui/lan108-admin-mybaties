package com.persistenthuang.lan108admin.service;

import com.persistenthuang.lan108admin.pojo.LanAuthor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
class LanAuthorServiceImplTest {

    @Autowired
    LanAuthorServiceImpl lanAuthorService;
    @Test
    void listAll() {
        log.info("listAll");
        log.info(lanAuthorService.ListAll().toString());
    }

    @Test
    void getByAuthorID() {
        log.info("getByAuthorID");
        log.info(lanAuthorService.getByAuthorID(1).toString());
    }

    @Test
    void getAllAuthorMessageById() {
        log.info("getAllAuthorMessageById");
        log.info(lanAuthorService.getByAuthorID(5).toString());

    }

    @Test
    void addAuthor() {
        log.info("addAuthor");
        LanAuthor lanAuthor = new LanAuthor();
        lanAuthor.setAuthorShowName("111");
        lanAuthor.setAuthorEmail("111@qq.com");
        lanAuthorService.addAuthor(lanAuthor);
    }

    @Test
    void updateAuthor() {
        log.info("updateAuthor");
        LanAuthor lanAuthor = new LanAuthor();
        lanAuthor.setId(2);
        lanAuthor.setAuthorShowName("111");
        lanAuthor.setAuthorEmail("111@qq.com");
        lanAuthor.setAuthorPhone("111111111");
        lanAuthorService.updateAuthor(lanAuthor);
    }

    @Test
    void isExitByAuthorEmail() {
        log.info("isExitByAuthorEmail");
        log.info(String.valueOf(lanAuthorService.isExitByAuthorEmail("111@qq.com")));
    }

    @Test
    void isExitByAuthorPhone() {
        log.info("isExitByAuthorPhone");
        log.info(String.valueOf(lanAuthorService.isExitByAuthorPhone("111@qq.com")));
        log.info(String.valueOf(lanAuthorService.isExitByAuthorPhone("141111111111")));

    }
}
