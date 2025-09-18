package com.forum.forum.module.service;

import com.forum.forum.module.entity.Account;
import com.forum.forum.module.entity.Post;
import com.forum.forum.module.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.List;

@Service
public class AccountService {

    @Resource
    private AccountMapper accountMapper;

    public Account signIn(String username, String password) {
        if (username == null || password == null) {
            return null;
        }

        Account account = accountMapper.signIn(username, password);
        if (account == null) {
            return null;
        }

        Account userInfo = new Account();
        userInfo.setAvatarUrl(account.getAvatarUrl());
        userInfo.setUsername(account.getUsername());
        userInfo.setEmail(account.getEmail());
        userInfo.setPassword(account.getPassword());
        userInfo.setDisplayName(account.getDisplayName());
        userInfo.setBio(account.getBio());
        userInfo.setPhone(account.getPhone());
        userInfo.setIsEmailVerified(account.getIsEmailVerified());
        userInfo.setIsPhoneVerified(account.getIsPhoneVerified());
        userInfo.setPosts(account.getPosts());
        userInfo.setCreateTime(account.getCreateTime());

        return userInfo;
    }

    public boolean signUp(Account account) {
        if (account == null) {
            return false;
        }
        return accountMapper.signUp(account);
    }

    public List<Post> getUserPosts(BigInteger userId) {
        return accountMapper.getUserPosts(userId);
    }
}
