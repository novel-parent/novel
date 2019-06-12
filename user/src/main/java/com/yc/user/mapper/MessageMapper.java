package com.yc.user.mapper;

import org.apache.ibatis.annotations.Param;

import java.sql.Date;

public interface MessageMapper {
    public void insert(@Param("uid")int uid,@Param("receiver")int receiver,@Param("senddate")Date senddate, @Param("title")String title,@Param("content") String content);
}
