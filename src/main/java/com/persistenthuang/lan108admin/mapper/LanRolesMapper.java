package com.persistenthuang.lan108admin.mapper;

import com.persistenthuang.lan108admin.pojo.LanRoles;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LanRolesMapper{
    LanRoles selectOne(LanRoles roles);
    List<LanRoles> selectList(LanRoles roles);
    int update(LanRoles roles);
}
