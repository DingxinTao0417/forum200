package com.forum.forum.app.controller;

import com.forum.forum.app.domain.Vo.AppStatusVo;
import com.forum.forum.app.domain.Vo.UserInfoVo;
import com.forum.forum.module.entity.Account;
import com.forum.forum.module.entity.Post;
import com.forum.forum.module.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    public AccountController() {}

    @RequestMapping("/user/info")
    public UserInfoVo userInfoVo(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password) {
        Account userInfo = accountService.signIn(username, password);
        if (userInfo == null) {
            return new UserInfoVo();
        }
        UserInfoVo userInfoVo = new UserInfoVo();
        List<Post> posts = new ArrayList<>();

        userInfoVo.setId(userInfo.getId());
        userInfoVo.setUsername(userInfo.getUsername());
        userInfoVo.setPassword(userInfo.getPassword());
        userInfoVo.setEmail(userInfo.getEmail());
        userInfoVo.setPhone(userInfo.getPhone());
        userInfoVo.setAvatarUrl(userInfo.getAvatarUrl());
        userInfoVo.setBio(userInfo.getBio());
        userInfoVo.setDisplayName(userInfo.getDisplayName());
        userInfoVo.setPosts(posts);
        int timestamp = userInfo.getCreateTime();
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTime = dateTime.format(formatter);
        userInfoVo.setCreateTime(formattedTime);

        return userInfoVo;
    }

    @RequestMapping("/user/signUp")
    public AppStatusVo signUp(@RequestParam(name = "username") String username, @RequestParam(name = "email") String email, @RequestParam(name = "password") String password) {

        boolean result = accountService.signUp(username, email, password);
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

    @RequestMapping("/user/posts")
    public List<Post> userPosts(@RequestParam(name = "author_id") BigInteger authorId) {
        return accountService.getUserPosts(authorId);
    }
}
