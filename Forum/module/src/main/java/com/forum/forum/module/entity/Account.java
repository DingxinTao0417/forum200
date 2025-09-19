package com.forum.forum.module.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigInteger;
import java.util.List;

@Data
@Accessors(chain = true)
public class Account {

    private BigInteger id;
    private String avatarUrl;
    private String username;
    private String email;
    private String password;
    private String displayName;
    private String bio;
    private String phone;
    private Integer isEmailVerified;
    private Integer isPhoneVerified;
    private Integer role;
    private Integer status;
    private Integer lastLoginTime;
    private Integer createTime;
    private Integer updateTime;
    private Integer deleteTime;
    private Integer isDeleted;
    private List<Post> posts;

}
