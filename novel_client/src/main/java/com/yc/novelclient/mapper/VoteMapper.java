package com.yc.novelclient.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

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
    int insReadNumber(long nid);

    /**
     *      更新 阅读数
     * @param nid
     * @return
     */
    int updReadNumber(long nid);


    /**
     *        插入
     * @param nid
     * @return
     */
    @Insert("INSERT INTO votenumber")
    int insVoteNumber(@Param("nid") long nid);

    /**
     *    更新
     * @param nid
     * @return
     */
    int updVoteNumber(long nid);
}
