package com.yc.novelclient.mapper;

import com.yc.bean.IntroductionNovel;
import org.apache.ibatis.annotations.Param;

/**
 * @author LX
 * @date 2019/5/17 - 19:44
 */
public interface NovelMapper {
    IntroductionNovel selNovelByNid(@Param("nid") long nid);
}
