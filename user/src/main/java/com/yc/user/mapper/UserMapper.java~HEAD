package com.yc.user.mapper;

import com.yc.user.bean.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author LX
 * @date 2019/5/26 - 21:01
 */
public interface UserMapper {

    User selByLogin(@Param("username") String username ,@Param("password") String password);

    void changeUserEdit(@Param("uid")long uid,@Param("email")String email,@Param("sex") String sex,@Param("qq") String qq);
}
