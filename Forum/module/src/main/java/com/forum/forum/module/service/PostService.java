package com.forum.forum.module.service;

import com.forum.forum.module.entity.Post;
import com.forum.forum.module.mapper.PostMapper;

import javax.annotation.Resource;

public class PostService {
    @Resource
    private PostMapper postMapper;

    public Post getPostById(Long id) {
        return postMapper.getPostById(id);
    }
}
