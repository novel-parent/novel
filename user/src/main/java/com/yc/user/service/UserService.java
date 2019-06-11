package com.yc.user.service;


import com.yc.user.bean.PageBean;
import com.yc.user.bean.User;
import com.yc.user.myexception.LoginException;


/**
 * @author LX
 * @date 2019/5/26 - 20:59
 */
public interface UserService {

    User selForLogin(String username , String password) throws LoginException;
    
    User findUserById(Integer uid);

	void UpdateUser(User u);

	void changePwd(User u);

	PageBean SerachPage(Integer uid, String page);

}
