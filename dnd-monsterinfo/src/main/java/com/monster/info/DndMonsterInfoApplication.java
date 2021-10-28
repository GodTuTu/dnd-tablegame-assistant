package com.monster.info;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.monster.info.mapper")
@SpringBootApplication()
public class DndMonsterInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DndMonsterInfoApplication.class, args);
    }
}
