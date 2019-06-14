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
import com.yc.loginregister.service.LoginRegisterService;

import redis.clients.jedis.Jedis;

@Controller
@SessionAttributes("loginedUser")
public class LoginRegesterController {

	@Autowired
	private LoginRegisterService userService;

	private Jedis jedis;

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
			@RequestParam("password") String password, @RequestParam("flag") boolean flag) {


		JsonModel jm = new JsonModel();

		try {
			
			User user = userService.selForLogin(username, password);

			// 登录成功
			String key = "uid:" + user.getUid();

			jedis.set(key, user.getUid() + "");
			// 设置key过期时间为30分钟
			jedis.expire(key, 60 * 60 * 30);
			
			jedis.del("num:"+username);

			jm.setCode((int) user.getUid()).setMsg("登录成功");
			
		} catch (LoginException e) {

			jm.setCode(-1).setMsg("登录失败!");
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
}
