package com.example.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.dao.UserDao;

import net.sf.json.JSONObject;

@Service
public class UserService {
    private final UserDao userdao;

    public UserService(UserDao userdao) {
        this.userdao = userdao;
    }

    public List<Map<String, Object>> getallusers() {
        return userdao.getallusers();
    }

    public String addoneusers(JSONObject json) {
        String name = (String) json.get("name");
        if (userdao.getuserbyname(name) == null) {
            return userdao.addoneusers(json); // 也就是“创建成功”
        } else {
            return "该用户已存在";
        }
    }

    public String login(String name, String password) {
        if (userdao.getuserbyname(name) == null) {
            return "该用户不存在";
        } else {
            String realpassword = userdao.getpasswordbyname(name);
            if (realpassword.equals(password)) {
                return "登录成功";
            } else {
                return "密码错误";
            }
        }
    }

    public Map<String, Object> getuserbyname(String name) {
        return userdao.getuserbyname(name);
    }
}
