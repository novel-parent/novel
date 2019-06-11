package com.yc.loginregister.service.impl;


import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.yc.loginregister.bean.User;
import com.yc.loginregister.mapper.UserMapper;
import com.yc.loginregister.myexception.LoginException;
import com.yc.loginregister.service.UserService;


/**
 * @author LX
 * @date 2019/5/26 - 20:59
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	public User selForLogin(String username, String password) throws LoginException {

        User user = userMapper.selByLogin(username, password);

        if(user == null){
            throw new LoginException("登录失败");
        }
        
        return user;
    }



	@Override
	public Map<String, String> getUserMap(User user) throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public User findUserById(Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public User findUser() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public User findUserByUserName(String username) {
		return userMapper.findUser(username);
	}



	@Override
	public Map<String, String> findUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

}
