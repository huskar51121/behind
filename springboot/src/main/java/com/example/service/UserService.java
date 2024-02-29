package com.example.service;

import org.springframework.stereotype.Service;

import com.example.dao.UserDao;

@Service
public class UserService {
    private final UserDao userdao;

    public UserService(UserDao userdao) {
        this.userdao = userdao;
    }

    public String name() {
        return userdao.name();
    }
}
