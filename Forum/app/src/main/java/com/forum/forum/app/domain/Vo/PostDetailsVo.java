package com.forum.forum.app.domain.Vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PostDetailsVo {
    private String title;
    private String contentMd;
    private String authorId;
    private String createTime;
    private String updateTime;
    private int likeNum;
    private int seenNum;
    private int replyNum;
}
