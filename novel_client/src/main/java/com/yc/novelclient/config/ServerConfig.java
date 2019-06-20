package com.yc.novelclient.config;

import com.yc.novelclient.filter.UserFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author LX
 * @date 2019/6/18 - 21:02
 */
@Configuration
public class ServerConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){

        System.out.println(888);
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();

        registrationBean.setFilter(new UserFilter());

        registrationBean.addUrlPatterns("/vipReadNovelChapter.n","/vipNovelChapters.n","/userReadNovelChapter.n","/userNovelChapters.n");

        return registrationBean;
    }
}
