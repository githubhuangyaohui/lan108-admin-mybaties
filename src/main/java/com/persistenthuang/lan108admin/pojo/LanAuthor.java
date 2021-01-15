package com.persistenthuang.lan108admin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LanAuthor implements Serializable {
    private int id;
    private String authorShowName;
    private LocalDateTime authorCreateData;
    private String authorEmail;
    private String authorPhone;
    private Boolean authorIsDelete;
}
