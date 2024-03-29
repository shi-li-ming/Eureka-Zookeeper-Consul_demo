package com.whpu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan(value = "com.whpu.mapper")
@EnableEurekaClient
@EnableDiscoveryClient
public class PaymentMain_8002 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain_8002.class,args);
    }
}
