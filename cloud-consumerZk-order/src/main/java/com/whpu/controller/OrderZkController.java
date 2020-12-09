package com.whpu.controller;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderZkController {

    public static  final String INVOKE_URL="http://cloud-provider-payment";
     @Resource
     private RestTemplate restTemplate;

     @GetMapping(value="/consumer/payment/zk")
       public String payment(){
       String result=   restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);
       return result;
     }
}
