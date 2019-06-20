package com.yc.user.mapper;

import com.yc.user.bean.Novel;
import com.yc.user.bean.SearchHistoryNovel;
import org.apache.ibatis.annotations.Param;

/**
 * @author LX
 * @date 2019/5/26 - 21:53
 */
public interface NovelMapper {

    SearchHistoryNovel selForSearchHistoryNovel(@Param("nid") long nid);

    Novel selectNovelByName(@Param("novelName")String novelName);

}
