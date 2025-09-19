package com.forum.forum.module.service;

import com.forum.forum.module.entity.Comment;
import com.forum.forum.module.mapper.CommentMapper;
import com.forum.forum.module.mapper.PostMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.List;

@Service
public class CommentService {

    @Resource
    private CommentMapper commentMapper;

    public List<Comment> getCommentsByPostId(BigInteger postId) {
        return commentMapper.getCommentsByPostId(postId);
    }
}
