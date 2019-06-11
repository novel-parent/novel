package com.yc.user.mapper;

import com.yc.user.bean.Message;
import com.yc.user.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author LX
 * @date 2019/5/26 - 21:01
 */
public interface UserMapper {

    User selByLogin(@Param("username") String username ,@Param("password") String password);

    void changeUserEdit(@Param("uid")long uid,@Param("email")String email,@Param("sex") String sex,@Param("qq") String qq);

    User findUserById(@Param("uid") Integer id);

	void upadateUser(User u);

	void changePwd(User u);

	//List<Message> SerachPage(@Param("uid")Integer uid,@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);
	
	List<Message> SerachPage(@Param("uid")Integer uid);

}
