package com.persistenthuang.lan108admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.persistenthuang.lan108admin.Result.ResuleMessage;
import com.persistenthuang.lan108admin.Result.Result;
import com.persistenthuang.lan108admin.pojo.LanRoles;
import com.persistenthuang.lan108admin.service.LanAdminServiceImpl;
import com.persistenthuang.lan108admin.service.LanRolesServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 专栏控制
 */
@Slf4j
@Controller
public class LanRolesController {
    @Autowired
    LanRolesServiceImpl lanRolesService;

    @Autowired
    LanAdminServiceImpl lanAdminService;

    /**
     * 获取专栏全部列表
     *
     * @return
     */
    @CrossOrigin
    @RequestMapping("/api/user/roleList")
    @ResponseBody
    public String selectRoleAll() {
        List<LanRoles> lanRoles = lanRolesService.getAllList();
        log.info("专栏列表:" + lanRoles.toString());
        return JSONObject.toJSONString(lanRoles);
    }


    /**
     * 根据ID获取专栏详细信息
     *
     * @return
     */
    @CrossOrigin
    @RequestMapping("/api/user/roleCard/Rid")
    @ResponseBody
    public String selectRoleMessage(@RequestBody JSONObject jsonObject) {
        int rid = jsonObject.getInteger("rid");
        LanRoles lanRole = lanRolesService.getRolesMessageByID(rid);
        log.info("专栏详细信息:" + lanRole.toString());
        return JSONObject.toJSONString(lanRole);
    }

    /**
     * 管理员修改专栏信息
     *
     * @param jsonObject
     * @return
     */
    @CrossOrigin
    @RequestMapping("/api/admin/changeRole")
    @ResponseBody
    public String UpdateRole(@RequestBody JSONObject jsonObject) {
        //接受前端信息
        int userID = jsonObject.getInteger("userId");
        LanRoles lanRoles = new LanRoles();
        lanRoles.setRolesLanName(jsonObject.getString("rolesLanName"));
        lanRoles.setRolesDescription(jsonObject.getString("rolesDescription"));
        lanRoles.setRolesImg(jsonObject.getString("rolesImg"));
        //获取专栏信息
        int roleId = lanAdminService.getRoleIdByUserId(userID);
        lanRoles.setId(roleId);
        if (lanRolesService.UpdateLanRoleById(lanRoles) != 0) {
            return JSONObject.toJSONString(new ResuleMessage(Result.SUCCESS, "修改成功"));
        } else {
            return JSONObject.toJSONString(new ResuleMessage(Result.FAILURE, "修改失败"));
        }

    }

    /**
     * 管理员获得专栏信息
     *
     * @param jsonObject
     * @return
     */
    @CrossOrigin
    @RequestMapping("/api/admin/RoleCard/Uid")
    @ResponseBody
    public String getRole(@RequestBody JSONObject jsonObject) {
        int userID = jsonObject.getInteger("userId");
        int roleId = lanAdminService.getRoleIdByUserId(userID);
        LanRoles rolesMessage = lanRolesService.getRolesMessageByID(roleId);
        log.info("专栏信息:" + rolesMessage.toString());
        return JSONObject.toJSONString(rolesMessage);
    }
}
