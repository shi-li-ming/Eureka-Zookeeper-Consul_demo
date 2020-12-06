package com.whpu.controller;


import com.commons.entity.CommentResult;
import com.commons.entity.Payment;

import com.whpu.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private  String serverPost;

    @Resource
    private DiscoveryClient discoveryClient;
    /**
     * 插入数据
     * @param payment
     * @return
     */
    @PostMapping(value="/payment/create")
    public CommentResult insert(Payment payment){
        int result=paymentService.insert(payment);
        log.info("****插入结果为:"+result);
        if(result>0){
            return new CommentResult(200,"插入数据库成功",result);
        }
        else{
            return  new CommentResult(444,"插入数据库失败",null);
        }
    }
    /**
     * 单查询数据
     */
    @GetMapping(value = "/payment/get/{id}")
    public CommentResult getPaymentByID(@PathVariable("id") Long id){
        Payment payment=  paymentService.getPaymentById(id);
        log.info("****查询成功："+payment);
        if(payment!=null){
            return new CommentResult(200,"查询成功！端口为："+serverPost,payment);
        }
        else{
            return  new CommentResult(444,"没有对应的记录,查询ID:"+id,null);
        }
    }
    /**
     * eureka服务发现
     */
    @GetMapping(value="/payment/discovery")
    public Object discovery(){
        //拿到注册信息

       List<String> services= discoveryClient.getServices();
        for (String element:services) {
         log.info("****element"+element);
        }
        /**
         * 拿到指定名称的所有的服务的注册信息比如pay模块，他们两个的名字都一样的，所以返回的是List
         *
         */
        List<ServiceInstance> instance=discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance serviceInstance:instance) {
          log.info(serviceInstance.getServiceId()+"/t"+serviceInstance.getHost()+"/t"+serviceInstance.getPort()+"/t"+serviceInstance.getUri());
        }
        return  this.discoveryClient;
    }
}


