package com.example.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.dao.UserDao;

import cn.hutool.core.date.DateUtil;
import net.sf.json.JSONObject;

@Service
public class UserService {
    private static String secretkey = "TG3WcVExt3gl8AkGdW5eKQMGjOCEAj5UeX9pcIuu7r6GcTFLJeqtpEye1wkP2Da1";
    private final UserDao userdao;

    public UserService(UserDao userdao) {
        this.userdao = userdao;
    }

    public List<Map<String, Object>> getallusers() {
        return userdao.getallusers();
    }

    public String addoneusers(JSONObject json) {
        String name = (String) json.get("name");
        // 把今天的日期赋给enddate，其实没什么意义
        json.put("enddate", LocalDate.now().toString());
        if (userdao.getuserbyname(name) == null) {

            return userdao.addoneusers(json); // 也就是“创建成功”
        } else {
            return "该用户已存在";
        }
    }

    public String login(String name, String password) {
        if (name == null) {
            return "请输入名称";
        }
        if (password == null) {
            return "请输入密码";
        }
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

    public static String createToken(String name) {

        return JWT.create().withAudience(name) // 将 user id 保存到 token 里面,作为载荷
                .withExpiresAt(DateUtil.offsetHour(new Date(), 24)) // 24小时后token过期
                .sign(Algorithm.HMAC256(secretkey)); // token 的密钥
    }

    public static String deToken(String token) {

        try {
            // 用户密码加签验证 token
            String name = JWT.decode(token).getAudience().get(0);
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(secretkey)).build();
            jwtVerifier.verify(token); // 验证token
            return name;
        } catch (JWTVerificationException e) {
            return "验证失败";
        }

    }
}
