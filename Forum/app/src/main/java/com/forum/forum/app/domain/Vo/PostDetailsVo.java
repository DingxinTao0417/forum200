package com.forum.forum.app.domain.Vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigInteger;

@Data
@Accessors(chain = true)
public class PostDetailsVo {
    private String title;
    private String contentMd;
    private BigInteger authorId;
    private String createTime;
    private String updateTime;
    private int likeNum;
    private int seenNum;
    private int replyNum;
}
