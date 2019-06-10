package mapper;

import bean.Message;
import bean.PageBean;
import bean.User;

import java.util.List;

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
