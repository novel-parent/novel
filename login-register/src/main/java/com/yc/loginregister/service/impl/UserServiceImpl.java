package com.yc.loginregister.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.loginregister.bean.User;
import com.yc.loginregister.mapper.UserMapper;
import com.yc.loginregister.myexception.LoginException;
import com.yc.loginregister.service.LoginRegisterService;

/**
 * @author LX
 * @date 2019/5/26 - 20:59
 */
@Service
public class UserServiceImpl implements LoginRegisterService {

	@Autowired
	private UserMapper userMapper;

	public User selForLogin(String username, String password) throws LoginException {

		User user = userMapper.selByLogin(username, password);

		if (user == null) {
			throw new LoginException("登录失败");
		}

		return user;
	}

	@Override
	public Map<String, String> getUserMap(User user) throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		Field[] field = user.getClass().getDeclaredFields();

		Map<String, String> userMap = new HashMap<String, String>();

		for (Field f : field) {
			userMap.put(f.getName(), user.getClass().getMethod(
					"get" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1, f.getName().length()))
					.invoke(user) + "");
		}

		return userMap;
	}

	@Override
	public User findUserById(Integer uid) {
		return userMapper.findUserById(uid);
	}

	@Override
	public User findUser(User user) {
		return userMapper.findUser(user.getUsername());
	}

	@Override
	public int addUser(User user) {
		user.setTitle("");
		return userMapper.addUser(user);
	}

}
