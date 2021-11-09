package com.mycompany.stringapiwrapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StringApiWrapperApplication {

    public static void main(String[] args) {
        SpringApplication.run(StringApiWrapperApplication.class, args);
    }

}
