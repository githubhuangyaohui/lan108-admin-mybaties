package com.persistenthuang.lan108admin.service;

import com.persistenthuang.lan108admin.mapper.LanAdminMapper;
import com.persistenthuang.lan108admin.pojo.LanAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanAdminServiceImpl implements LanAdminService {

    @Autowired
    LanAdminMapper lanAdminMapper;

    // 通过专栏ID判断专栏是否有管理员
    @Override
    public boolean isExitByRoleId(int roleId) {
        LanAdmin admin = new LanAdmin();
        admin.setRoleId(roleId);
        List<LanAdmin> lanAdmins = lanAdminMapper.selectList(admin);
        return lanAdmins != null;
    }

    // 通过UserID判断专栏是否有管理员
    @Override
    public boolean isExitByUserId(int userId) {
        LanAdmin admin = new LanAdmin();
        admin.setUserId(userId);
        List<LanAdmin> lanAdmins = lanAdminMapper.selectList(admin);
        return lanAdmins != null;
    }

    // 通过专栏ID获取管理员userID
    @Override
    public int getUserIdByRoleId(int roleId) {
        LanAdmin admin = new LanAdmin();
        admin.setRoleId(roleId);
        List<LanAdmin> lanAdmins = lanAdminMapper.selectList(admin);
        return lanAdmins.get(0).getUserId();
    }

    // 通过userID获取专栏ID
    @Override
    public int getRoleIdByUserId(int userID) {
        LanAdmin admin = new LanAdmin();
        admin.setUserId(userID);
        List<LanAdmin> lanAdmins = lanAdminMapper.selectList(admin);
        return lanAdmins.get(0).getRoleId();
    }
}
