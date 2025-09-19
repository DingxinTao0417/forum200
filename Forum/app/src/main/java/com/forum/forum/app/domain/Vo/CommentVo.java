package com.forum.forum.app.domain.Vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigInteger;

@Data
@Accessors(chain = true)
public class CommentVo {
    private BigInteger authorId;
    private String content;
    private Integer likeNum;
    private String createTime;
}
