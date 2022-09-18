package cn.itcast.order.service;

import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import cn.itcast.order.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RestTemplate restTemplate;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        //  2.查询到的订单包括一个用户的id,需要一个远程调用的url
        String url = "http://userServer/user/"+order.getUserId();
        User user = restTemplate.getForObject(url, User.class);
        //  3.封装
        order.setUser(user);
        // 4.返回
        return order;
    }
}