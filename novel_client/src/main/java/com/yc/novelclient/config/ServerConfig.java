package com.yc.novelclient.config;

import com.yc.novelclient.filter.UserFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author LX
 * @date 2019/6/18 - 21:02
 */
@Configuration
public class ServerConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){

        FilterRegistrationBean registrationBean = new FilterRegistrationBean();

        registrationBean.setFilter(new UserFilter());

        registrationBean.addUrlPatterns("/");

        return registrationBean;
    }
}
