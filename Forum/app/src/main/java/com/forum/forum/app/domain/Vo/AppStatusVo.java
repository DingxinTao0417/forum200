package com.forum.forum.app.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class AppStatusVo {
    private int statusCode;
    private String message;
}
