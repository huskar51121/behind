package com.example.service;

import com.example.dao.OrderDao;
import com.example.entity.Order;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    // 获取所有订单
    public List<Map<String, Object>> getAllOrders() {
        return orderDao.getallorders();
    }

    // 通过用户ID获取所有订单
    public List<Map<String, Object>> getAllOrdersById(int id) {
        return orderDao.getallordersbyid(id);
    }

    // 通过订单名称获取订单
    public Map<String, Object> getOrderByOrderName(String name) {
        return orderDao.getorderbyorderid(name);
    }

    // 通过订单ID进行支付更新
    public String payOrderByOrderId(int orderid) {
        return orderDao.paybyorderid(orderid);
    }

    // 添加一个新订单
    public String addOneOrder(JSONObject json) {
        // 在创建新订单前，需要先将JSONObject转换为order实体类，并填充所有必要信息
        if (json == null) {
            return "订单信息为空";
        }

        // 假设json对象含有所有必要字段
        Order newOrder = new Order();
        newOrder.setid(json.optInt("id"));
        newOrder.setprice(json.optString("price"));
        newOrder.setdays(json.optString("days"));
        newOrder.setpurchaseDate(json.optString("purchaseDate"));
        newOrder.setpayornot(json.optInt("payornot", 0)); // 默认为0未支付

        // 校验newOrder对象字段，确保都有值

        // 这里我们直接调用DAO层的方法，但在实际应用中可能还会进行一些比如订单校验等其它业务操作
        return orderDao.addoneorder(json);
    }
}