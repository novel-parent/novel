package com.yc.loginregister.service;

import com.yc.loginregister.bean.User;
import com.yc.loginregister.myexception.LoginException;

/**
 * @author LX
 * @date 2019/5/26 - 20:59
 */
public interface UserService {

    User selForLogin(String username , String password) throws LoginException;
}
