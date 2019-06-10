package com.yc.user.mapper;

<<<<<<< HEAD:user/src/main/java/mapper/UserMapper.java
import bean.Message;
import bean.PageBean;
import bean.User;

import java.util.List;

=======
import com.yc.user.bean.User;
>>>>>>> 7cbcc8c1b613281e7f6b330daf7ec482042452f7:user/src/main/java/com/yc/user/mapper/UserMapper.java
import org.apache.ibatis.annotations.Param;

/**
 * @author LX
 * @date 2019/5/26 - 21:01
 */
public interface UserMapper {

    User selByLogin(@Param("username") String username ,@Param("password") String password);
    
    User findUserById(@Param("uid") Integer id);

	void upadateUser(User u);

	void changePwd(User u);

	//List<Message> SerachPage(@Param("uid")Integer uid,@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);
	
	List<Message> SerachPage(@Param("uid")Integer uid);

}
