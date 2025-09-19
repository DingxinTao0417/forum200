package com.forum.forum.app.domain.Vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class CommentListVo {
    private List<CommentVo> list;
}
