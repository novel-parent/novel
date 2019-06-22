package com.yc.loginregister.bean;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.yc.loginregister.service.LoginRegisterService;

import redis.clients.jedis.Jedis;

public class UserRealm extends AuthorizingRealm{
	
	@Autowired
	private LoginRegisterService loginRegisterService;
	
	private Jedis jedis;
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		jedis = new Jedis("106.14.162.109", 6379);
		jedis.auth("lsx666");
		
		UsernamePasswordToken tk= (UsernamePasswordToken) token;
		
		//从数据库获取user对象
		User user = loginRegisterService.findUser(new User().setUsername(tk.getUsername()));
		
		if(user == null) {
			return null;
		}
		
		Object principal=user;
		
		Object credentials=user.getPassword();
		
		String realmName=getName();
		
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal,credentials, realmName);
		
		jedis.set("uid:"+user.getUid(), user.getUsername());
		
		jedis.expire("uid:"+user.getUid(), 1800);
		
		return info;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		return null;
	}



}
