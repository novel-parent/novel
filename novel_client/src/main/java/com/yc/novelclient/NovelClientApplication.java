package com.yc.novelclient;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@ServletComponentScan
@SpringBootApplication
@EnableRabbit
@EnableCaching
public class NovelClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(NovelClientApplication.class, args);
    }

}
