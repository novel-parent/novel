package service;

import bean.User;
import myexception.LoginException;

/**
 * @author LX
 * @date 2019/5/26 - 20:59
 */
public interface UserService {

    User selForLogin(String username , String password) throws LoginException;

    void changeUserEdit( long uid, String email, String sex, String qq);
}
