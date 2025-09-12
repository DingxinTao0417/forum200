package com.forum.forum.module.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigInteger;
import java.util.List;

@Data
@Accessors(chain = true)
public class Account {

    @JsonProperty("id")
    private BigInteger id;
    @JsonProperty("avatar_url")
    private String avatarUrl;
    @JsonProperty("username")
    private String username;
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
    @JsonProperty("display_name")
    private String displayName;
    @JsonProperty("bio")
    private String bio;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("is_email_verified")
    private Integer isEmailVerified;
    @JsonProperty("is_phone_verified")
    private Integer isPhoneVerified;
    @JsonProperty("role")
    private Integer role;
    @JsonProperty("status")
    private Integer status;
    @JsonProperty("last_login_time")
    private Integer lastLoginTime;
    @JsonProperty("create_time")
    private Integer createTime;
    @JsonProperty("update_time")
    private Integer updateTime;
    @JsonProperty("delete_time")
    private Integer deleteTime;
    @JsonProperty("is_deleted")
    private Integer isDeleted;
    @JsonProperty("posts")
    private List<Post> posts;

}
