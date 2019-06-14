package com.yc.loginregister.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import com.yc.loginregister.bean.JsonModel;
import com.yc.loginregister.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;


import com.yc.loginregister.mapper.UserMapper;
import com.yc.loginregister.myexception.LoginException;
import com.yc.loginregister.service.UserService;

import redis.clients.jedis.Jedis;

@Controller
@SessionAttributes("loginedUser")
public class LoginRegesterController {
	
	@Autowired
	private UserService userService;
	
	private Jedis jedis;
	
	
	
	//初始化方法,创建jedis对象
	@ModelAttribute
	public void init() {
		jedis =new Jedis("106.14.162.109",6379);
		jedis.auth("lsx666");
	}
	
	/**
	 * @param: username   用户名
	 *         password   密码
	 *         JsonModel.code : 1:正常登录  -1:登陆失败    0:用户被锁定
	 * @author: hdl
	 */

	@ResponseBody
	@PostMapping("login.l")
	public Object login(Model model, @RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("flag") boolean flag) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{

		JsonModel jm=new JsonModel();
		/*Jedis jedis =new Jedis("106.14.162.109",6379);
		jedis.auth("lsx666");*/
		User user = null;
		
		//通过用户名查找到该用户
		User lockedUser=userService.findUserByUserName(username);

		//设置当前登录用户登录次数，时间为三分钟
		String loginNumKey="loginNum:"+lockedUser.getUid();
		
		//判断是不是存在loginNumKey
		if(!jedis.exists(loginNumKey)) {
			
			jedis.set(loginNumKey, "0");
			jedis.expire(loginNumKey, 60*3);
			
		}
		
		
		//判断该用户是否被限制登录,如果被限制登录则return
		if(jedis.exists("lockuser:"+lockedUser.getUid())) {
			
			jm.setCode(0).setMsg("您已登录失败超过5次请一分钟后再来吧！");
			
		}else {
			

			try {
				user = userService.selForLogin(username, password);
				
				//登录成功
				String key="uid:"+user.getUid();
				
				jedis.set(key, user.getUid()+"");
				//设置key过期时间为30分钟
				jedis.expire(key, 60*60*30);
				
				jm.setCode((int) user.getUid());
				
			} catch (LoginException e) {
				
                int loginTime=Integer.parseInt(jedis.get(loginNumKey))+1;
                
                jedis.set(loginNumKey, ""+loginTime);
                
                System.out.println(loginTime);
				
				if(loginTime <= 5) {
					
					jm.setCode(-1).setMsg("登录失败!");
					
				}else {
					
					String key="lockuser:"+lockedUser.getUid();
					
					jedis.set(key, username);
					
					//设置该用户锁定登录1分钟
					if(!jedis.exists(key)) {
						jedis.expire(key,60*1);
					}
					
					jm.setCode(0).setMsg("您已登录失败超过5次请一分钟后再来吧！");
				}
				
				e.printStackTrace();
			}
		}

		
		jedis.close();
		
		return jm;
	}

	@RequestMapping("register.l")
	@ResponseBody
	public Object test(User user) {
		JsonModel jm = new JsonModel();
		

		
		if (userService.findUser(user).size() > 0) {
			jm.setCode(-1).setMsg("该用户已被注册!");
			return jm;
		}

		if (userService.addUser(user) > 0) {
			jm.setCode(1).setMsg("注册成功！");
		} else {
			jm.setCode(-1).setMsg("系统繁忙!");
		}

		return jm;
	}
}
