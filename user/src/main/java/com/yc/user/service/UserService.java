package com.yc.user.service;

<<<<<<< HEAD:user/src/main/java/service/UserService.java
import java.util.List;

import bean.Message;
import bean.PageBean;
import bean.User;
import myexception.LoginException;
=======
import com.yc.user.bean.User;
import com.yc.user.myexception.LoginException;
>>>>>>> 7cbcc8c1b613281e7f6b330daf7ec482042452f7:user/src/main/java/com/yc/user/service/UserService.java

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
