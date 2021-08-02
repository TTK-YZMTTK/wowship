package com.wows.ships;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;



@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@ComponentScan({"com.wows"})
@MapperScan("com.wows.ships.mapper")
public class ShipApplication {
    public static void main(String[] args){
        SpringApplication.run(ShipApplication.class,args);}
}
