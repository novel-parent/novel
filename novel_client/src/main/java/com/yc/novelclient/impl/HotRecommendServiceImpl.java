package com.yc.novelclient.impl;

import java.util.List;

import com.yc.novelclient.MyException.BizException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.bean.IntroductionNovel;

import com.yc.novelclient.mapper.HotRecommendMapper;
import com.yc.novelclient.service.HotRecommendService;

/**
 * @author sm
 * @date 2019/5/23 - 23:50
 */
@Service
public class HotRecommendServiceImpl implements HotRecommendService{
	
	@Autowired
	private HotRecommendMapper hotRecommendMapper;


	/**
	 * 获取到小说表中的所有数据
	 */

	@Override
	public List<IntroductionNovel> selectHotMonths() throws BizException {
		// TODO Auto-generated method stub
		List<IntroductionNovel> inNovels = hotRecommendMapper.selectHotMonths();
		return inNovels;
	}
	
	
}
