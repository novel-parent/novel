package com.yc.user.mapper;

import com.yc.user.bean.Message;
import com.yc.user.bean.User;
import com.yc.user.bean.Vip;

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

	void upadateUser(User user);

	void changePwd(User u);

	//List<Message> SerachPage(@Param("uid")Integer uid,@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);
	
	List<Message> SerachPage(@Param("uid")Integer uid);

	int chongZhiVip(@Param("uid") long uid,@Param("startTimes") long startTime,@Param("endTimes") long endTime);

	void UpdateUserVip(long uid);

	Vip findUserIsOrNotVip(long uid);

	int UpdateUsersVip(@Param("uid") long uid,@Param("endTimes") long endTimes);

	User selUserByUid(@Param("uid") long uid);

}
