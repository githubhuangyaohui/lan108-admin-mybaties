package com.persistenthuang.lan108admin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LanMassage {
    private int id;
    private int userId;    //用户id
    private int blogId;    //推送id
    private LocalDateTime msgCreatData;           //发送时间
    private int msgType;           //消息类型
    private boolean msgIdRead;//是否已阅
}
