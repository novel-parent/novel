package com.yc.user.config;

import com.yc.user.flter.UserFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 *
 *          @Configuration
 * @author LX
 * @date 2019/6/18 - 21:02
 */

public class ServerConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){

        System.out.println(888);
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();

        registrationBean.setFilter(new UserFilter());

        registrationBean.addUrlPatterns("/userInfo.u");

        return registrationBean;
    }
}
