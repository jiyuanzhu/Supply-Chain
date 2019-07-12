package com.djj.mywe3sdk;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.djj,mywe3sdk.dao")
public class Mywe3sdkApplication {



    public static void main(String[] args) {



        SpringApplication.run(Mywe3sdkApplication.class, args);
    }

}
