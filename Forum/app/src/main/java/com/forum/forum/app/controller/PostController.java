package com.forum.forum.app.controller;

import com.forum.forum.app.domain.Dto.PostDto;
import com.forum.forum.app.domain.Vo.AppStatusVo;
import com.forum.forum.app.domain.Vo.PostDetailsVo;
import com.forum.forum.app.domain.Vo.PostInfoVo;
import com.forum.forum.app.domain.Vo.PostListVo;
import com.forum.forum.module.entity.Post;
import com.forum.forum.module.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    @RequestMapping("/post/all")
    public PostListVo postList() {
        List<Post> posts = this.postService.getAllPosts();
        if (posts == null || posts.isEmpty()) {
            return new PostListVo();
        }

        List<PostInfoVo> postInfoVoList = new ArrayList();
        Iterator var3 = posts.iterator();

        while(var3.hasNext()) {
            Post post = (Post) var3.next();
            PostInfoVo postInfoVo = new PostInfoVo();
            postInfoVo.setTitle(post.getTitle());
            postInfoVo.setAuthorId(post.getAuthorId());
            postInfoVo.setPostId(post.getId());
            postInfoVo.setLikeNum(post.getLikeNum());
            int timestamp = post.getCreateTime();
            LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneId.systemDefault());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedTime = dateTime.format(formatter);
            postInfoVo.setCreateTime(formattedTime);
            postInfoVoList.add(postInfoVo);
        }

        PostListVo postListVo = new PostListVo();
        postListVo.setList(postInfoVoList);

        return postListVo;
    }

    @RequestMapping("/post/details")
    public PostDetailsVo postDetails(@RequestParam(name = "id") BigInteger postId) {
        Post post = postService.getPostById(postId);
        if (post == null) {
            return new PostDetailsVo();
        }

        PostDetailsVo postDetailsVo = new PostDetailsVo();
        postDetailsVo.setTitle(post.getTitle());
        postDetailsVo.setAuthorId(post.getAuthorId());
        postDetailsVo.setContentMd(post.getContentMd());
        int timestamp = post.getCreateTime();
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTime = dateTime.format(formatter);
        postDetailsVo.setCreateTime(formattedTime);

        timestamp = post.getCreateTime();
        dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneId.systemDefault());
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        formattedTime = dateTime.format(formatter);
        postDetailsVo.setUpdateTime(formattedTime);

        postDetailsVo.setLikeNum(post.getLikeNum());
        postDetailsVo.setSeenNum(post.getSeenNum());
        postDetailsVo.setReplyNum(post.getReplyNum());

        return postDetailsVo;
    }
}
