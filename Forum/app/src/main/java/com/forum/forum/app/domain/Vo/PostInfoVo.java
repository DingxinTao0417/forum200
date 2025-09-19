package com.forum.forum.app.domain.Vo;

import lombok.Data;

import java.math.BigInteger;

@Data
public class PostInfoVo {
    private String title;
    private BigInteger authorId;
    private BigInteger postId;
    private String createTime;
    private int likeNum;
}
