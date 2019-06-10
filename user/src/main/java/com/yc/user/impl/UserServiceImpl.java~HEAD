package com.yc.user.impl;

import com.yc.user.bean.User;
import com.yc.user.mapper.UserMapper;
import com.yc.user.myexception.LoginException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yc.user.service.UserService;

/**
 * @author LX
 * @date 2019/5/26 - 20:59
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    public User selForLogin(String username, String password) throws LoginException {

        User user = userMapper.selByLogin(username, password);

        if(user == null){
            throw new LoginException("登录失败");
        }

        return user;
    }

    public void changeUserEdit( long uid, String email, String sex, String qq){

        userMapper.changeUserEdit(uid,email,sex,qq);
    }

}
