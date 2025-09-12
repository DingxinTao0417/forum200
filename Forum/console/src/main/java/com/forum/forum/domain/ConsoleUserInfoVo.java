package com.forum.forum.domain;

import com.forum.forum.module.entity.Post;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class ConsoleUserInfoVo {
    private String username;
    private String password;
    private String email;
    private String phone;
    private String avatarUrl;
    private String bio;
    private String displayName;
    private List<Post> Posts;
    private String createTime;
    private int isEmailVerified;
    private int isPhoneVerified;
    private int role;
    private int lastLoginTime;
    private int updateTime;
    private int deleteTime;
    private int isDeleted;
}
