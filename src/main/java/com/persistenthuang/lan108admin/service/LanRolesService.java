package com.persistenthuang.lan108admin.service;

import com.persistenthuang.lan108admin.pojo.LanRoles;

import java.util.List;

public interface LanRolesService {
    LanRoles getRolesMessageByID(int RolesId);
    List<LanRoles> getAllList();
    int UpdateLanRoleById(LanRoles role);
}
