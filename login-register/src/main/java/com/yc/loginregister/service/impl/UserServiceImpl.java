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

<<<<<<< HEAD
    public void changeUserEdit(long uid,String email,String sex,String qq){

         userMapper.changeUserEdit(uid, email, sex, qq);
    }
=======


	@Override
	public Map<String, String> getUserMap(User user) throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub
		return null;
	}
>>>>>>> 7653caad7811ce287d48021230ada57f800610c3

}
