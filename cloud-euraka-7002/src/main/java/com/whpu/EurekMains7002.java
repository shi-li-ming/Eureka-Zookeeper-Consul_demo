package com.whpu;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekMains7002 {

    public static void main(String[] args) {
        SpringApplication.run(EurekMains7002.class,args);
    }

}
