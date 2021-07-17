package com.persistenthuang.lan108admin.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
class LanAdminServiceImplTest {

    @Autowired
    LanAdminServiceImpl lanAdminService;
    @Test
    void isExitByRoleId() {
        log.info("isExitByRoleId");
        log.info(String.valueOf(lanAdminService.isExitByRoleId(5)));
        log.info(String.valueOf(lanAdminService.isExitByRoleId(1)));
    }

    @Test
    void isExitByUserId() {
        log.info("isExitByUserId");
        log.info(String.valueOf(lanAdminService.isExitByUserId(5)));
        log.info(String.valueOf(lanAdminService.isExitByUserId(4)));
    }

    @Test
    void getUserIdByRoleId() {
        log.info("getUserIdByRoleId");
        log.info(String.valueOf(lanAdminService.getUserIdByRoleId(1)));
    }

    @Test
    void getRoleIdByUserId() {
        log.info("getRoleIdByUserId");
        log.info(String.valueOf(lanAdminService.getRoleIdByUserId(5)));

    }
}
