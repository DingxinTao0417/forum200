package com.forum.forum.module.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigInteger;

@Data
@Accessors(chain = true)
public class Post {
    private BigInteger id;

    private BigInteger authorId;

    private String title;

    private String contentMd;

    private Integer replyNum;

    private Integer likeNum;

    private Integer seenNum;

    private Integer createTime;

    private Integer updateTime;

    private Integer deleteTime;

    private Integer status;

    private Integer isDeleted;
}
