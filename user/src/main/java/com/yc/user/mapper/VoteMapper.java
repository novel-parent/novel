package com.yc.user.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author LX
 * @date 2019/7/17 - 12:29
 */
public interface VoteMapper {

    /**
     *            插入 阅读数
     * @param nid
     * @return
     */
    @Insert("INSERT INTO readnumber(nid,number) VALUE(#{nid},1)")
    int insReadNumber(@Param("nid") long nid);

    /**
     *      更新 阅读数
     * @param nid
     * @return
     */
    @Update("UPDATE readnumber SET number = number +1 WHERE nid = #{nid}")
    int updReadNumber(@Param("nid") long nid);


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
