package com.persistenthuang.lan108admin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LanBlogs implements Serializable {
    private int id;
    private int blogsAuthorId;              //作者ID
    private LocalDateTime blogsCreateData;  //创建时间
    private String blogsTitle;              //标题
    private String blogsCover;              //标题
    private String blogsSummary;              //摘要
    private String blogsHtml;              //html
    private String blogsContent;            //内容
    private int blogsColumn;             //分类
    private String blogsPassword;           //密码
    private int blogsStatus;            //状态：0代表未发表，1代表发表
}
