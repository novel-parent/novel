package com.yc.user.service;

import com.yc.user.bean.PageBean;
import com.yc.user.bean.User;
import com.yc.user.bean.Vip;
import com.yc.user.myexception.LoginException;
import com.yc.user.myexception.MyException;

import java.util.Map;

/**
 * @author LX
 * @date 2019/5/26 - 20:59
 */
public interface UserService {

    User selForLogin(String username , String password) throws LoginException;

    void changeUserEdit( long uid, String email, String sex, String qq) throws MyException;

    User findUserById(Integer uid);

	void UpdateUser(User u);

	void changePwd(User u);

	PageBean SerachPage(Integer uid, String page);

    void sendToManager(String title,String content) throws MyException;

	Map<String, String> getUserMap(User user) throws Exception;

	User getEditUser(User user);

	void chongZhiCode(long uid, int money);


	int chongZhiVip(long uid, int money);

	void UpdateUserVip(long parseLong);

	Vip findUserIsOrNotVip(long l);

	int UpdateUsersVip(long parseLong, int parseInt, Vip vip);

	int deleteFromMsg(String mid);

	int deleteFromMsgByUid(String uid);

}
