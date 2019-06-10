package com.yc.novelclient.controller;

import java.util.List;

import com.yc.novelclient.MyException.BizException;
import com.yc.novelclient.service.HotRecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.IntroductionNovel;

@Controller
public class HotRecommendController {

	@Autowired
	private HotRecommendService hotRecommendServiceImpl;
	
	/**
	 * 本月热门
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/HotMonths.n")
	public List<IntroductionNovel> HotThisMonth() {
		
			List<IntroductionNovel> inNovels = null;
			try {
				inNovels = hotRecommendServiceImpl.selectHotMonths();//获取小说的所有数据
			} catch (BizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			return inNovels;
	}
}
