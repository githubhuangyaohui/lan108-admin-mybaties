package com.persistenthuang.lan108admin.service;

import com.persistenthuang.lan108admin.pojo.LanRoles;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
class LanRolesServiceImplTest {

    @Autowired
    LanRolesServiceImpl lanRolesService;
    @Test
    void getRolesMessageByID() {
        log.info("getRolesMessageByID");
        log.info(String.valueOf(lanRolesService.getRolesMessageByID(1)));
    }

    @Test
    void getAllList() {
        log.info("getAllList");
        log.info(String.valueOf(lanRolesService.getAllList()));

    }

    @Test
    void updateLanRoleById() {
        log.info("updateLanRoleById");
        LanRoles lanRoles = new LanRoles();
        lanRoles.setId(1);
        lanRoles.setRolesLanName("lan108");
        lanRoles.setRolesDescription("lan108");
        log.info(String.valueOf(lanRolesService.UpdateLanRoleById(lanRoles)));
    }
}
