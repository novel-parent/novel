package com.yc.user.config;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置驼峰命名法
 * @author LX
 * @date 2019/6/9 - 11:11
 */
@MapperScan("com.yc.user.mapper")
@Configuration
public class MybatisConfig {

    @Bean
    public ConfigurationCustomizer configurationCustomizer(){

        return (configuration )->{
            // 开启 驼峰命名规则
            configuration.setMapUnderscoreToCamelCase(true);
        };
    }
}
