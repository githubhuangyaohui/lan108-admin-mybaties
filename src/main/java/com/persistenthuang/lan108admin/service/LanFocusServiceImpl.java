package com.persistenthuang.lan108admin.service;

import com.persistenthuang.lan108admin.mapper.LanFocusMapper;
import com.persistenthuang.lan108admin.pojo.LanFocus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanFocusServiceImpl implements LanFocusService {
    @Autowired
    LanFocusMapper lanFocusMapper;

    /**
     * 判断是否关注
     *
     * @param userID userID
     * @param roleID roleID
     * @return 是否关注
     */
    @Override
    public boolean isFocus(int userID, int roleID) {
        LanFocus focus =new LanFocus();
        focus.setUserId(userID);
        focus.setRoleId(roleID);
        LanFocus lanFocus = lanFocusMapper.selectOne(focus);
        return lanFocus != null;
    }

    /**
     * 关注专栏
     *
     * @param userID
     * @param roleID
     * @return
     */
    @Override
    public int getFocus(int userID, int roleID) {
        LanFocus focus =new LanFocus();
        focus.setUserId(userID);
        focus.setRoleId(roleID);
        return lanFocusMapper.insert(focus);

    }

    /**
     * 取消关注专栏
     *
     * @param userID
     * @param roleID
     * @return
     */
    @Override
    public int getUnnFocus(int userID, int roleID) {
        LanFocus focus =new LanFocus();
        focus.setUserId(userID);
        focus.setRoleId(roleID);
        return lanFocusMapper.delete(focus);
    }

    @Override
    public List<LanFocus> getFocusUserByRoleId(int roleId) {
        LanFocus focus =new LanFocus();
        focus.setRoleId(roleId);
        return lanFocusMapper.selectList(focus);
    }
}
