package com.yc.loginregister.config;

import com.yc.loginregister.filter.LoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author LX
 * @date 2019/6/13 - 17:58
 */
@Configuration
public class ServerConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){

        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new LoginFilter());
        registrationBean.addUrlPatterns("/login.l");
        return registrationBean;
    }
}
