package com.yc.novelclient.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author LX
 * @date 2019/7/17 - 17:26
 */
public interface ReadMapper {

    /**
     *     查询 阅读数
     * @param nid
     * @return
     */
    @Select("SELECT nid FROM readnumber where nid =#{nid} ")
    int selReadNumber(@Param("nid") long nid);
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
}
