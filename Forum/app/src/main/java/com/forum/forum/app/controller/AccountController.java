package com.forum.forum.app.controller;

import com.forum.forum.app.domain.PostListVo;
import com.forum.forum.app.domain.UserInfoVo;
import com.forum.forum.module.entity.Account;
import com.forum.forum.module.entity.Post;
import com.forum.forum.module.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
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

        userInfoVo.setUsername(userInfo.getUsername());
        userInfoVo.setPassword(userInfo.getPassword());
        userInfoVo.setEmail(userInfo.getEmail());
        userInfoVo.setPhone(userInfo.getPhone());
        userInfoVo.setAvatarUrl(userInfo.getAvatarUrl());
        userInfoVo.setBio(userInfo.getBio());
        userInfoVo.setDisplayName(userInfo.getDisplayName());
        userInfoVo.setPosts(posts);

        return userInfoVo;
    }
}
