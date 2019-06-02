package service.impl;

import bean.User;
import mapper.UserMapper;
import myexception.LoginException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

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
}
