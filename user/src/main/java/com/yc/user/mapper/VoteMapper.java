package com.yc.user.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author LX
 * @date 2019/7/17 - 12:29
 */
public interface VoteMapper {


    /**
     *     查询 投票数
     * @param nid
     * @return
     */
    @Select("SELECT nid FROM votenumber WHERE nid = #{nid}")
    Long selVoteNumber(@Param("nid") long nid);

    /**
     *        插入
     * @param nid
     * @return
     */
    @Insert("INSERT INTO votenumber(nid,number) VALUE(#{nid} ,1)")
    int insVoteNumber(@Param("nid") long nid);

    /**
     *    更新
     * @param nid
     * @return
     */
    @Update("UPDATE votenumber SET number = number+1 WHERE nid = #{nid}")
    int updVoteNumber(@Param("nid") long nid);
}
