package com.persistenthuang.lan108admin.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
class LanFocusServiceImplTest {

    @Autowired
    LanFocusServiceImpl lanFocusService;
    @Test
    void isFocus() {
        log.info("isFocus");
        log.info(String.valueOf(lanFocusService.isFocus(5,2)));
        log.info(String.valueOf(lanFocusService.isFocus(5,6)));
    }

    @Test
    void getFocus() {
        log.info("getFocus");
        lanFocusService.getFocus(5,3);

    }

    @Test
    void getUnnFocus() {
        log.info("getUnnFocus");
        lanFocusService.getUnnFocus(5,3);
    }

    @Test
    void getFocusUserByRoleId() {
        log.info("getFocusUserByRoleId");
        log.info(String.valueOf(lanFocusService.getFocusUserByRoleId(2)));
    }
}
