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
class LanMassageServiceImplTest {

    @Autowired
    LanMassageServiceImpl lanMassageService;
    @Test
    void sendMessage() {
        log.info("sendMessage");
        lanMassageService.sendMessage(1,1);
    }

    @Test
    void getMassageListByUserId() {
        log.info("getMassageListByUserId");
        log.info(String.valueOf(lanMassageService.getMassageListByUserId(1).toString()));
    }

    @Test
    void setIsRead() {
        log.info("setIsRead");
        lanMassageService.setIsRead(1,1);
    }
}
