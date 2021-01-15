package com.persistenthuang.lan108admin.service;

import com.persistenthuang.lan108admin.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
class UserServiceImplTest {

    @Autowired
    UserServiceImpl userService;

    @Test
    void isExistByName() {
        log.info("isExistByName");
        log.info(String.valueOf(userService.isExistByName("huang")));
        log.info(String.valueOf(userService.isExistByName("111")));
    }

    @Test
    void isExistByEmail() {
        log.info("isExistByEmail");
        log.info(String.valueOf(userService.isExistByEmail("persistenthuang@163.com")));
        log.info(String.valueOf(userService.isExistByEmail("111")));
    }

    @Test
    void isExistByID() {
        log.info("isExistByID");
        log.info(String.valueOf(userService.isExistByID(5)));
        log.info(String.valueOf(userService.isExistByID(6)));
    }

    @Test
    void isAuthor() {
        log.info("isAuthor");
        log.info(String.valueOf(userService.isAuthor(5)));
    }

    @Test
    void getAuthorID() {
        log.info("getAuthorID");
        log.info(String.valueOf(userService.getAuthorID(5)));
    }

    @Test
    void getByName() {
        log.info("getByName");
        log.info(userService.getByName("huang").toString());
    }

    @Test
    void getAllMessageByName() {
        log.info("getAllMessageByName");
        log.info(userService.getByName("huang").toString());
    }

    @Test
    void getUserById() {
        log.info("getUserById");
        log.info(userService.getUserById(5).toString());
    }

    @Test
    void add() {
        log.info("add");
        User user = new User();
        user.setUserName("test");
        user.setUserPassword("test");
        user.setUserSalt("test");
        user.setUserSex(true);
        user.setUserEmail("test");
        userService.add(user);
    }

    @Test
    void updateAuthor() {
        log.info("updateAuthor");
        User user = new User();
        user.setId(6);
        user.setUserName("test2");
        user.setUserPassword("test2");
        user.setUserSalt("test2");
        user.setUserSex(false);
        user.setUserEmail("test2");
        userService.updateAuthor(user);
        log.info(user.toString());
    }
}
