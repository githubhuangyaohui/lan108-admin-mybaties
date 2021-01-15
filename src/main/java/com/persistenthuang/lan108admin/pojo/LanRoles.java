package com.persistenthuang.lan108admin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LanRoles implements Serializable {
    private int id;
    private String rolesLanName;
    private int rolesState;
    private String rolesStarname;
    private String rolesNickname;
    private String rolesTruename;
    private String rolesDescription;
    private String rolesImg;
}
