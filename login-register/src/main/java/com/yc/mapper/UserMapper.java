package com.yc.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.yc.bean.User;

/**
 * @author LX
 * @date 2019/5/26 - 21:01
 */

public interface UserMapper {

    User selByLogin(@Param("username") String username ,@Param("password") String password);

	int addUser(User user);

	List<User> findUser(User user);

	
}
