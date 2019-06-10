package com.yc.loginregister.service.impl;


import redis.clients.jedis.Jedis;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

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
	public User findUserById(Integer uid) {

		User user = userMapper.findUserById(uid);

		return user;
	}

	@Override
	public void UpdateUser(User u) {
		userMapper.upadateUser(u);
	}

	@Override
	public void changePwd(User u) {

		userMapper.changePwd(u);
	}

	@Override
	public PageBean SerachPage(Integer uid, String page) {
		int pageNum=0;
		int pageSize=1;
		
		
		if ( page != null && ! "".equals(page)) {
			pageNum=Integer.parseInt(page.trim());
		} 
		
		System.out.println("PageNum"+pageNum+"===================PageSize:"+pageSize);
		/*List<Message> msg=userMapper.SerachPage(uid, pageNum, pageSize);
		
		return new PageBean().setCurrengPagenum(pageNum).setPageList(msg).setPerPageSize(pageSize).setTotalpagenum(3);*/
		
		
		Page<Message>  msg = PageHelper.startPage(pageNum, pageSize, true);
			userMapper.SerachPage(uid);
			for (Message m : msg.getResult()) {
				System.out.println(m);
			}
	
		return new PageBean().setPageList(msg.getResult()).setCurrengPagenum(msg.getPageNum()).setPerPageSize(msg.getPageSize())
			.setTotalpagenum((int) msg.getPages());
		
		
		
	}

	@Override
	public Map<String, String> getUserMap(User user) throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub
		return null;
	}

}
