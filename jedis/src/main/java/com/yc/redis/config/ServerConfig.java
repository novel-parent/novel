package com.yc.redis.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author LX
 * @date 2019/6/16 - 19:48
 */
@Configuration
public class ServerConfig {

        @Bean
        public FilterRegistrationBean filterRegistrationBean(){

            FilterRegistrationBean registrationBean = new FilterRegistrationBean();
            registrationBean.setFilter(new com.yc.redis.filter.UserLoginFilterConfig());
            registrationBean.addUrlPatterns("/");

            return registrationBean;
        }
}
