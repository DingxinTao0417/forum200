package com.forum.forum.app.controller;

import com.forum.forum.module.entity.Post;
import com.forum.forum.module.service.PostService;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Resource;

public class PostController {
    @Resource
    PostService postService;

    public Post getPostById(Long id) {
        return postService.getPostById(id);
    }
}
