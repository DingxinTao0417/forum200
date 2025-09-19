package com.forum.forum.app.domain.Vo;

import com.forum.forum.module.entity.Post;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigInteger;
import java.util.List;

@Data
@Accessors(chain = true)
public class UserInfoVo {
    private BigInteger id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String avatarUrl;
    private String bio;
    private String displayName;
    private List<Post> Posts;
    private String createTime;
}
