package com.yc.loginregister.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import com.yc.loginregister.bean.User;
import com.yc.loginregister.myexception.LoginException;

/**
 * @author LX
 * @date 2019/5/26 - 20:59
 */
public interface LoginRegisterService {

	/**
	 *      根据音频得到 文字
	 * @param path
	 * @return
	 */
	String getVoice(String path);

    User selForLogin(String username , String password) throws LoginException;

	Map<String, String> getUserMap(User user) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException;

	User findUserById(Integer uid);

	int addUser(User user);

	User findUser(User user);

	User findCookieUser(String setUsername);
}
