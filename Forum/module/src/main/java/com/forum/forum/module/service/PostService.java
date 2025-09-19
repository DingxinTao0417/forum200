package com.forum.forum.module.service;

import com.forum.forum.module.entity.Post;
import com.forum.forum.module.mapper.PostMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PostService {
    @Resource
    private PostMapper postMapper;

    public boolean createPost(Post post) {
        return postMapper.createPost(post);
    }

    public List<Post> getAllPosts() {
        return postMapper.getAll();
    }
}
