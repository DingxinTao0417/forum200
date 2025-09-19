package com.forum.forum.module.mapper;

import com.forum.forum.module.entity.Comment;
import com.forum.forum.module.entity.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface CommentMapper {

    @Select("select * from comments where post_id = #{postId} and status = 1 and is_deleted = 0")
    List<Comment> getCommentsByPostId(@Param("postId") BigInteger postId);
}
