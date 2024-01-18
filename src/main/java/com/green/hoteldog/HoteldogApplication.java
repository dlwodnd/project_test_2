package com.green.hoteldog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication//(exclude = SecurityAutoConfiguration.class)스프링 시큐리티 비활성화
public class HoteldogApplication {

    public static void main(String[] args) {
        SpringApplication.run(HoteldogApplication.class, args);
    }

}
