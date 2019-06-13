package com.yc.loginregister.mapper;


import java.util.List;
import java.util.Map;

import com.yc.loginregister.bean.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author LX
 * @date 2019/5/26 - 21:01
 */

public interface UserMapper {

    User selByLogin(@Param("username") String username , @Param("password") String password);

	int addUser(User user);

	User findUser(@Param("username") String username);

	void changeUserEdit(long uid, String email, String sex, String qq);


	
}
