package com.persistenthuang.lan108admin.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LanAd implements Serializable {
    private int id;
    private String lanAdImage;                        //广告图片链接
    private String lanAdLink;                        //广告跳转链接
}
