package com.forum.forum.app.domain.Vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class PostListVo {
    private List<PostInfoVo> list;
}