package com.whpu.order.controller;

import com.commons.entity.CommentResult;
import com.commons.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;


/***
 * 服务消费者
 */
@RestController
@Slf4j
public class OrderController {
    /**
     *单机
     *private static  final String PAYMENT_URL="http://localhost:8001";
     */
      //改为微服务名称每次访问都去eureka中拿地址，就会轮询拿到负载均衡效果了
    //CLOUD-PAYMENT-SERVICE
   private static  final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommentResult<Payment> getPatment(Payment payment){
       return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment, CommentResult.class);
    }
    /**
     * 添加数据
     */
    @GetMapping("/consumer/payment/get/{id}")
    public CommentResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommentResult.class);
    }
}
