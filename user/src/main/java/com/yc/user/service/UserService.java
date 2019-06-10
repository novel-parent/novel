package com.yc.user.service;

import com.yc.user.bean.User;
import com.yc.user.myexception.LoginException;
import org.springframework.stereotype.Service;

/**
 * @author LX
 * @date 2019/5/26 - 20:59
 */
@Service
public interface UserService {

    User selForLogin(String username , String password) throws LoginException;

    void changeUserEdit( long uid, String email, String sex, String qq);
}
