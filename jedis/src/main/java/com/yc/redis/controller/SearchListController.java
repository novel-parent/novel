package com.yc.redis.controller;

import com.yc.redis.service.GetListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author LX
 * @date 2019/6/12 - 21:42
 */
@RestController
public class SearchListController {
    @Autowired
    private GetListService getListService;
    /**
     * 获取搜索排行榜前30
     */
    @RequestMapping("/getSearchList.r")
    public Map<String,Object> getSearchList(){
        return getListService.getSearchList();
    }

    /**
     * 获取收藏排行榜前30
     */
    @RequestMapping("/getConlectionList.r")
    public Map<String,Object> getConlectionList(){
        return getListService.getConlectionList() ;
    }

    /**
     * 获取推荐排行榜前30
     */
    @RequestMapping("/getRecommendList.r")
    public Map<String,Object> getRecommendList(){
        return getListService.getRecommendList();
    }

    /**
     * 测试
     */
    @PostMapping("/test.r")
    public String getTest(){
        return "ok";
    }
}
