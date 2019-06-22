package com.yc.redis.mapper;

import com.yc.redis.bean.CollectDiv;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author LX
 * @date 2019/6/21 - 20:21
 */
@Mapper
public interface ListMapper {

    /**
     * 查询数据库 得到  收藏数前15 的小说基本信息
     * @return
     */
    @Select("select n.nid, n.novelName,n.author ,co.number from novel n , collectNumber co where n.nid = co.nid order by co.number desc limit 0 ,15")
    List<CollectDiv> selCollectForHotList();

    /**
     * 查询数据库 得到  阅读数前15 的小说基本信息
     * @return
     */
    @Select("select n.nid, n.novelName,n.author ,co.number from novel n , readnumber co where n.nid = co.nid order by co.number desc limit 0 ,15")
    List<CollectDiv> selReadForHotList();

    /**
     * 查询数据库 得到  投票数前15 的小说基本信息
     * @return
     */
    @Select("select n.nid, n.novelName,n.author ,co.number from novel n , votenumber co where n.nid = co.nid order by co.number desc limit 0 ,15")
    List<CollectDiv> selVoteForHotList();

    /**
     * 查询数据库 得到 该用户最近搜索历史6条
     * @return
     */
    @Select("select historySearchName from  historysearch where uid=#{uid} ORDER BY sid desc limit 0,6")
    List<String> selSearchHistory(Integer uid);
}
