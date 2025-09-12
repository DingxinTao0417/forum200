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

    @Update("INSERT INTO users (username, password, email, phone, avatar_url, bio, display_name, create_time, is_email_verified, is_phone_verified, role, last_login_time, update_time, delete_time, is_deleted) " +
            "VALUES (#{username}, #{password}, #{email}, #{phone}, #{avatarUrl}, #{bio}, #{displayName}, #{createTime}, #{isEmailVerified}, #{isPhoneVerified}, #{role}, #{lastLoginTime}, #{updateTime}, #{deleteTime}, #{isDeleted})")
    boolean signUp(Account account);
}
