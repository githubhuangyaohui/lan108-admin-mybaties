package com.persistenthuang.lan108admin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LanFocus implements Serializable {
    private int id;
    private int userId;
    private int roleId;
}
