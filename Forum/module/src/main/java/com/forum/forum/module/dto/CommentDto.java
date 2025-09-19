package com.forum.forum.module.dto;

import lombok.Data;
import java.math.BigInteger;

@Data
public class CommentDto {
    private BigInteger authorId;
    private BigInteger postId;
    private String content;
}
