package com.forum.forum.app.controller;

import com.forum.forum.app.domain.Vo.CommentListVo;
import com.forum.forum.app.domain.Vo.CommentVo;
import com.forum.forum.module.entity.Comment;
import com.forum.forum.module.service.CommentService;
import com.forum.forum.module.service.PostService;
import lombok.extern.slf4j.Slf4j;
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
public class CommentController {

    @Resource
    CommentService commentService;

    @RequestMapping("/comment/list")
    public CommentListVo listComments(@RequestParam("postId") BigInteger postId) {
        List<Comment> comments = commentService.getCommentsByPostId(postId);
        if (comments == null || comments.isEmpty()) {
            return new CommentListVo();
        }

        List<CommentVo> commentVoList = new ArrayList<>();
        Iterator var3 = comments.iterator();

        while(var3.hasNext()) {
            Comment comment = (Comment)var3.next();
            CommentVo commentVo = new CommentVo();
            commentVo.setAuthorId(comment.getAuthorId());
            commentVo.setContent(comment.getContent());
            commentVo.setLikeNum(comment.getLikeNum());
            int timestamp = comment.getCreateTime();
            LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneId.systemDefault());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedTime = dateTime.format(formatter);
            commentVo.setCreateTime(formattedTime);

            commentVoList.add(commentVo);
        }

        CommentListVo commentListVo = new CommentListVo();
        commentListVo.setList(commentVoList);

        return commentListVo;
    }
}
