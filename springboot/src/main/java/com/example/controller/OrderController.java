package com.example.controller;

import java.time.LocalDate;
import net.sf.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.service.OrderService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // 获取所有订单
    @PostMapping("/all")
    public ResponseEntity<List<Map<String, Object>>> getAllOrders() {
        try {
            List<Map<String, Object>> orders = orderService.getAllOrders();
            return ResponseEntity.ok(orders);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // 根据用户ID获取所有订单
    @PostMapping("/user/myOrder")
    public ResponseEntity<List<Map<String, Object>>> getAllOrdersByUserId(String idData) {

        List<Map<String, Object>> orders = orderService.getAllOrdersById(Integer.parseInt(idData));
        return ResponseEntity.ok(orders);

    }

    // 通过订单名称获取订单
    @PostMapping("/name/{orderName}")
    public ResponseEntity<Map<String, Object>> getOrderByOrderName(@PathVariable("orderName") String orderName) {
        try {
            Map<String, Object> order = orderService.getOrderByOrderName(orderName);
            return ResponseEntity.ok(order);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // 通过订单ID进行支付更新
    @PostMapping("/pay/{orderId}")
    public ResponseEntity<String> payOrderByOrderId(@PathVariable("orderId") int orderId) {
        try {
            String result = orderService.payOrderByOrderId(orderId);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("支付失败：" + e.getMessage());
        }
    }

    // 添加一个新订单
    @PostMapping("/add")
    public ResponseEntity<String> addOneOrder(String time, String price, String userid) {
        JSONObject json = new JSONObject();
        json = new JSONObject();
        json.put("days", time);
        json.put("price", price);
        json.put("id", Integer.parseInt(userid));
        json.put("purchaseDate", LocalDate.now().toString());
        String result = orderService.addOneOrder(json);
        return ResponseEntity.ok(result);
    }
}