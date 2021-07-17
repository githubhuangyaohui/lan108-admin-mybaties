package com.persistenthuang.lan108admin.mapper;

import com.persistenthuang.lan108admin.pojo.LanRoles;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LanRolesMapper{
    LanRoles selectOne(@Param("roles")LanRoles roles);
    List<LanRoles> selectList(@Param("roles") LanRoles roles);
    int update(@Param("roles")LanRoles roles);
}
