package com.yc.loginregister.config;

import java.util.LinkedHashMap;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yc.loginregister.bean.UserRealm;

@Configuration
public class ShiroConfig {
	
	@Bean("shiroFilter")
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
		ShiroFilterFactoryBean sffb=new ShiroFilterFactoryBean();
		
		sffb.setSecurityManager(securityManager);
		
		sffb.setLoginUrl("/login.html");
		
		
		LinkedHashMap<String, String> fm=new LinkedHashMap<>();
		
		
		fm.put("/login/*","anon");
		
		fm.put("/register/*","anon");
		
		//fm.put("/**","authc");
		
		sffb.setFilterChainDefinitionMap(fm);
		
		return sffb;
	}
	
	
	@Bean("securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("ur") UserRealm userRealm) {
		DefaultWebSecurityManager dwsm=new DefaultWebSecurityManager();
		dwsm.setRealm(userRealm);
		dwsm.setAuthenticator(dwsm);
		
		return dwsm;
	}
	
	

	@Bean("ur")
	public UserRealm getRealm() {
		return new UserRealm();
	}
}
