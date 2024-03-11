package com.example.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import net.sf.json.JSONObject;

@Repository
public class OrderDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getallorders() {

        String sql = "select * from `order`";
        List<Map<String, Object>> list_map = jdbcTemplate.queryForList(sql);
        return list_map;

    }

    public List<Map<String, Object>> getallordersbyid(int id) {

        String sql = "select * from `order` WHERE id LIKE \'" +
                id +
                "\';";
        List<Map<String, Object>> list_map = jdbcTemplate.queryForList(sql);
        return list_map;

    }

    public Map<String, Object> getorderbyorderid(String name) {
        String sql = "SELECT * FROM `order` WHERE name LIKE\'" +
                name +
                "\';";
        try {
            Map<String, Object> map = jdbcTemplate.queryForMap(sql);
            return map;
        } catch (Exception e) {
            return null;
        }
    }

    public String paybyorderid(int orderid) {
        String sql = "UPDATE `order` \n SET payornot = \'1\' \n WHERE orderid = \'" +
                orderid +
                "\';";
        try {
            jdbcTemplate.update(sql);
            return "支付成功";
        } catch (Exception e) {
            return "支付失败";
        }
    }

    public String addoneorder(JSONObject json) {
        String sql = "insert into `order`(id,price,days,purchaseDate,payornot) values (\'" +
                json.get("id") + "\',\'" +
                json.get("price") + "\',\'" +
                json.get("days") + "\',\'" +
                json.get("purchaseDate") + "\',\'" +
                "0" + "\'" + // 0 表示未支付
                ");";
        jdbcTemplate.update(sql);
        return "创建成功";
    }
}
