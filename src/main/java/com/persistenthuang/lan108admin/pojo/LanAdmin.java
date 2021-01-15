package com.persistenthuang.lan108admin.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LanAdmin implements Serializable {
    private int id;
    private int userId;                        //用户id
    private int roleId;                        //用户角色ID
    private LocalDateTime adminCreatData;     //创建时间
    private boolean adminIsDelete;            //是否删除
}
