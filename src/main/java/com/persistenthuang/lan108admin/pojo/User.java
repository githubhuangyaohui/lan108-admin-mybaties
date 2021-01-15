package com.persistenthuang.lan108admin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private int id;
    private int userAuthorId;
    private String userName;
    private String userPassword;
    private String userSalt;
    private boolean userSex;
    private String userEmail;
    private int userLevel;
    private int userRole;
    private LocalDateTime userRegisterTime;
    private boolean userIsDelete;
}
