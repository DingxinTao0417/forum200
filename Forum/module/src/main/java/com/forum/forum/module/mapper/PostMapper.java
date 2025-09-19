package com.forum.forum.module.mapper;

import com.forum.forum.module.entity.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface PostMapper {

    boolean createPost(Post post);

    @Select("select * from posts WHERE status = 1 AND is_deleted = 0 limit 99")
    List<Post> getAll();

    @Select("select * from  posts where id = #{id} and status = 1 and is_deleted = 0")
    Post getPostById(@Param("id") BigInteger id);
}
