package com.yc.loginregister.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.loginregister.bean.CookieModel;
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
import com.yc.loginregister.service.LoginRegisterService;

import redis.clients.jedis.Jedis;

@Controller
@SessionAttributes("loginedUser")
public class LoginRegesterController {

	@Autowired
	private LoginRegisterService userService;

	private Jedis jedis;
	
	public static final int LoginSessionTime=1800;
	
	public static final int CookieTime=60*60*24*7;

	// 初始化方法,创建jedis对象
	@ModelAttribute
	public void init() {
		jedis = new Jedis("106.14.162.109", 6379);
		jedis.auth("lsx666");
	}

	/**
	 * @param: username 用户名 password 密码 JsonModel.code : 1:正常登录 -1:登陆失败 0:用户被锁定
	 * @author: hdl
	 */

	@ResponseBody
	@PostMapping("login.l")
	public Object login(Model model, @RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("flag") boolean flag,HttpServletResponse response,HttpServletRequest request) {


		JsonModel jm = new JsonModel();

		try {
			
			User user = userService.selForLogin(username, password);

			// 登录成功设置的key
			String key = "uid:" + user.getUid();
			
			//设置ip地址的key
			String ipkey="uip:" + user.getUid();
			
			//获取登录用户的ip地址
			String ip= request.getRemoteAddr();
			
			if(jedis.exists(ipkey)) {
				
				jm.setCode(-1).setMsg("该用户已在别的设备登录");
				
			}else if(jedis.exists(key)){
				
				jm.setCode(-1).setMsg("您已登录，无需再登录");
				
			} else {
				
				
				//设置cookie
				if(flag) {
					//在创建cookie之前判断是否之前有设置过cookie
					Cookie[] cookies=request.getCookies();
					
					for(Cookie c:cookies) {
						if(!username.equals(String.valueOf(c.getValue()))) {
							
							Cookie usernamecookie=new Cookie("uname",username);
							Cookie userpwdcookie=new Cookie("upwd",password);
							//设置cookie过期时间为7天
							usernamecookie.setMaxAge(CookieTime);
							userpwdcookie.setMaxAge(CookieTime);
							
							response.addCookie(userpwdcookie);
							response.addCookie(usernamecookie);
						}
					}
				}else {
					//如果未选择记住登陆状态则判断该用户之前是否有设置cookie，如果有则删除该cookie
					Cookie[] cookies= request.getCookies();
					
					for(Cookie c:cookies) {
						if(username.equals(c.getValue())) {
							Cookie usernamecookie=new Cookie("uname",username);
							Cookie userpwdcookie=new Cookie("upwd",password);
							usernamecookie.setMaxAge(0);
							userpwdcookie.setMaxAge(0);
							usernamecookie.setPath("/");
							userpwdcookie.setPath("/");
							response.addCookie(userpwdcookie);
							response.addCookie(usernamecookie);
						}
					}
				}
				
				// 设置用户登录key
				jedis.set(key, user.getUid() + "");
				
				//设置ip地址的key判断用户是不是在别的地方登录
				jedis.set(ipkey, ip);
				
				// 设置用户登录key过期时间为30分钟
				jedis.expire(key, LoginSessionTime);
				jedis.expire(ipkey, LoginSessionTime);
				
				jm.setCode((int) user.getUid()).setMsg("登录成功");
			}
			
			jedis.del("num:"+username);

		} catch (LoginException e) {

			jm.setCode(-1).setMsg("账号或密码错误!");
			e.printStackTrace();
		}

		return jm;
	}

	@RequestMapping("register.l")
	@ResponseBody
	public Object test(User user) {
		JsonModel jm = new JsonModel();

		if (userService.findUser(user) != null) {
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
	
	@RequestMapping("getcookie.l")
	@ResponseBody
	public Object getCookie(HttpServletRequest request) {
		CookieModel cookie=new CookieModel();
		for(Cookie c: request.getCookies()) {
			if("uname".equals(c.getName())) {
				cookie.setUsername(c.getValue());
			}
			if("upwd".equals(c.getName())) {
				cookie.setPassword(c.getValue());
			}
		}
		return cookie;
	}
}
