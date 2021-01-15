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
class LanAdServiceImplTest {

    @Autowired
    LanAdServiceImpl lanAdService;
    @Test
    void getLanAdList() {
        log.info("广告列表");
        log.info(lanAdService.getLanAdList().toString());
    }
}
