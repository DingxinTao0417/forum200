package com.forum.forum.module.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigInteger;

@Data
@Accessors(chain = true)
public class Comment {
    private BigInteger id;
    private BigInteger authorId;
    private BigInteger postId;
    private String content;
    private Integer likeNum;
    private Integer createTime;
    private Integer updateTime;
    private Integer deleteTime;
    private Integer status;
    private Integer isDeleted;
}
