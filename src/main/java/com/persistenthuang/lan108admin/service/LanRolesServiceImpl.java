package com.persistenthuang.lan108admin.service;
import com.persistenthuang.lan108admin.mapper.LanRolesMapper;
import com.persistenthuang.lan108admin.pojo.LanRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanRolesServiceImpl implements LanRolesService {
    @Autowired
    LanRolesMapper lanRolesMapper;
    // 通过ID获取专栏信息
    @Override
    public LanRoles getRolesMessageByID(int id) {
        LanRoles roles =new LanRoles();
        roles.setId(id);
        return lanRolesMapper.selectOne(roles);
    }

    // 获取所有专栏
    @Override
    public List<LanRoles> getAllList() {
        LanRoles lanRoles = new LanRoles();
        lanRoles.setRolesState(1);
        return lanRolesMapper.selectList(lanRoles);
    }

    @Override
    public int UpdateLanRoleById(LanRoles role) {
        return lanRolesMapper.update(role);
    }
}
