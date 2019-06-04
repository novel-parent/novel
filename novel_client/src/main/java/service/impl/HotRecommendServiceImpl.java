package service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.bean.IntroductionNovel;

import MyException.BizException;
import mapper.HotRecommendMapper;
import service.HotRecommendService;

/**
 * @author sm
 * @date 2019/5/23 - 23:50
 */
@Service
public class HotRecommendServiceImpl implements HotRecommendService{
	
	@Autowired
	private HotRecommendMapper hotRecommendMapper;
	
	
	//获取到小说表中的所有数据
	public List<IntroductionNovel> selectHotMonths() throws BizException{
		// TODO Auto-generated method stub
		List<IntroductionNovel> inNovels = hotRecommendMapper.selectHotMonths();
		return inNovels;
	}
	
	
}
