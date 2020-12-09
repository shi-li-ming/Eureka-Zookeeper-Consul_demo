package com.whpu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    private static  final String ULR_VALUE="http://cloud-consul-provider-payment";
    @Resource
    private RestTemplate restTemplate;

    @Value("${server.port}")
    private String serverPost;

    @GetMapping(value="/consumer/payment/consul")
    public String getPayemnt(){
        String result=   restTemplate.getForObject(ULR_VALUE+"/payment/consul",String.class);
        return result;
    }
}
