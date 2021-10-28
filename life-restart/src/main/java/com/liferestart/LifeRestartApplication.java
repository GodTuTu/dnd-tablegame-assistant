package com.liferestart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.liferestart.mapper")
@SpringBootApplication()
public class LifeRestartApplication {

    public static void main(String[] args) {
        SpringApplication.run(LifeRestartApplication.class, args);
    }
}
