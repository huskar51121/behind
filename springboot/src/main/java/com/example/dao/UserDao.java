package com.example.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import net.sf.json.JSONObject;

@Repository
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getallusers() {

        String sql = "select * from user";
        List<Map<String, Object>> list_map = jdbcTemplate.queryForList(sql);
        return list_map;

    }

    public Map<String, Object> getuserbyname(String name) {
        String sql = "SELECT * FROM user WHERE name LIKE\'" +
                name +
                "\';";
        try {
            Map<String, Object> map = jdbcTemplate.queryForMap(sql);
            return map;
        } catch (Exception e) {
            return null;
        }

    }

    public String addoneusers(JSONObject json) {
        String sql = "insert into user(name,password,phone,enddate) values (\'" +
                json.get("name") + "\',\'" +
                json.get("password") + "\',\'" +
                json.get("phone") + "\',\'" +
                json.get("enddate") + "\'" +
                ");";
        jdbcTemplate.update(sql);
        return "创建成功";
    }

    public String getpasswordbyname(String name) {
        String sql = "SELECT password FROM user WHERE name LIKE\'" +
                name +
                "\';";
        try {
            String password = jdbcTemplate.queryForObject(sql, String.class);
            return password;
        } catch (Exception e) {
            return null;
        }
    }
}
