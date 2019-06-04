package com.yc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yc.bean.JsonModel;
import com.yc.bean.User;
import com.yc.mapper.UserMapper;
import com.yc.myexception.LoginException;
import com.yc.service.UserService;

@Controller
@SessionAttributes("loginedUser")
public class LoginRegesterController {
	@Autowired
	private UserMapper userService;

	@ResponseBody
	@RequestMapping("login.l")
	public String login(Model model, @RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("flag") boolean flag) {

		String message = "-1";

		User user = userService.selByLogin(username, password);

		model.addAttribute("loginedUser", user);

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
