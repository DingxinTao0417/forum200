package com.forum.forum.module.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.forum.forum.module.entity.Account;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface AccountMapper {

    @Select("SELECT * FROM users WHERE (username=#{username} AND password=#{password} AND status=1 AND is_deleted=0)")
    Account signIn(@Param("username") String username, @Param("password") String password);
}
