package com.yc.novelclient.mapper;

import java.util.List;

import com.yc.bean.IntroductionNovel;

/**
 * 
 * @author Administrator
 * 2019-5-23
 */
public interface HotRecommendMapper {

	//查询所有的小说
	public List<IntroductionNovel> selectHotMonths();
}
