package com.forum.forum.app.domain.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigInteger;

@Data
@Accessors(chain = true)
public class PostDto {
    @JsonProperty("author_id")
    private BigInteger authorId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("content_md")
    private String contentMd;
}
