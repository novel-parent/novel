package com.yc.redis.controller;

import com.yc.redis.service.GetListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
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
    public Map<String,Map> getSearchList(HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Origin","*");
        return getListService.getSearchList();
    }

    /**
     * 获取收藏排行榜前30
     */
    @RequestMapping("/getConlectionList.r")
    public Map<String,Map> getConlectionList(HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Origin","*");
        return getListService.getConlectionList() ;
    }

    /**
     * 获取推荐排行榜前30
     */
    @RequestMapping("/getRecommendList.r")
    public Map<String,Map> getRecommendList(HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Origin","*");
        return getListService.getRecommendList();
    }

    /**
     * 测试
     */
    @RequestMapping("/test.r")
    public String getTest(HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Origin","*");
        getListService.getTest();
        return "ok";
    }
}
