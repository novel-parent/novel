package com.yc.loginregister.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import com.yc.loginregister.bean.JsonModel;
import com.yc.loginregister.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;


import com.yc.loginregister.mapper.UserMapper;
import com.yc.loginregister.service.UserService;

import redis.clients.jedis.Jedis;

@Controller
@SessionAttributes("loginedUser")
public class LoginRegesterController {
	@Autowired
	private UserMapper userService;
	
	@Autowired
	private UserService userSer;

	@ResponseBody
	@RequestMapping("login.l")
	public String login(Model model, @RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("flag") boolean flag) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

		String message = "-1";

		User user = userService.selByLogin(username, password);

		//model.addAttribute("loginedUser", user);
		
		Jedis jedis=new Jedis("106.14.162.109",6379);
		jedis.auth("lsx666");
		
		
		Map<String,String> um=userSer.getUserMap(user);
		
//		jedis.hmset("user:"+user.getUid(),um);
		

		message = "uid =" + user.getUid();
		
		return message;
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
