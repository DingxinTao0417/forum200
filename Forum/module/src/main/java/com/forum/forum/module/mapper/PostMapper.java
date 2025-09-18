package com.forum.forum.module.mapper;

import com.forum.forum.module.entity.Post;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper {

    boolean createPost(Post post);

}
