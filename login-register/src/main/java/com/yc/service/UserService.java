package com.yc.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import com.yc.bean.User;
import com.yc.myexception.LoginException;

/**
 * @author LX
 * @date 2019/5/26 - 20:59
 */
public interface UserService {

    User selForLogin(String username , String password) throws LoginException;

	Map<String, String> getUserMap(User user) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException;
}
