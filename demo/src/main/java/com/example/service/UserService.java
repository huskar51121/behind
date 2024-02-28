package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.entity.user;

import jakarta.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserDao userDao;

    public List<user> getUser() {
        return userDao.getUser();
    }
}
