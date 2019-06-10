package com.yc.novelclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class NovelClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(NovelClientApplication.class, args);
    }

}
