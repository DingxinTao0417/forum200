package com.forum.forum.app.controller;

import com.forum.forum.app.domain.Dto.PostDto;
import com.forum.forum.app.domain.Vo.AppStatusVo;
import com.forum.forum.module.entity.Post;
import com.forum.forum.module.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
public class PostController {
    @Resource
    PostService postService;

    /*
    * /post/create
    * /post/update
    * /post/delete
    * /post/list (分页)
    *
    *
    *
    * */

    @RequestMapping("/post/create")
    public AppStatusVo createPost(@RequestBody PostDto post) {
        Post newPost = new Post();
        newPost.setAuthorId(post.getAuthorId());
        newPost.setTitle(post.getTitle());
        newPost.setContentMd(post.getContentMd());
        int timestamp = (int) (System.currentTimeMillis() / 1000);
        newPost.setCreateTime(timestamp);
        newPost.setLikeNum(0);
        newPost.setReplyNum(0);
        newPost.setSeenNum(0);
        newPost.setStatus(2);


        boolean result = postService.createPost(newPost);
        AppStatusVo appStatusVo = new AppStatusVo();
        if (result) {
            appStatusVo.setStatusCode(0);
            appStatusVo.setMessage("Sign up successful");
        } else {
            appStatusVo.setStatusCode(1);
            appStatusVo.setMessage("Sign up failed");
        }
        return appStatusVo;
    }
}
