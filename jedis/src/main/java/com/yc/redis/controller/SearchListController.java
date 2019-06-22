package com.yc.redis.controller;

import com.yc.redis.bean.CollectDiv;
import com.yc.redis.service.GetListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Set;

/**
 * @author LX
 * @date 2019/6/12 - 21:42
 */
@RestController
public class SearchListController {
    @Autowired
    private GetListService getListService;
    /**
     * 获取热门搜索 前6条
     */
    @RequestMapping("/getSearchHistory.r")
    public Set<String> selSearchHistory(HttpServletResponse resp, Integer uid){
        resp.setHeader("Access-Control-Allow-Origin","*");
        return getListService.selSearchHistory();
    }

    /**
     * 获取阅读-热门 排行榜前15
     */
    @RequestMapping("/getReadList.r")
    public List<CollectDiv> getReadList(HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Origin","*");
        return getListService.getReadList("read");
    }

    /**
     * 获取收藏排行榜前15
     */
    @RequestMapping("/getCollectionList.r")
    public List<CollectDiv> getCollectionList(HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Origin","*");
        return getListService.getCollectionList("collection") ;
    }

    /**
     * 获取推荐排行榜前15
     */
    @RequestMapping("/getRecommendList.r")
    public List<CollectDiv> getRecommendList(HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Origin","*");
        return getListService.getRecommendList("vote");
    }

    /**
     * 测试
     */
    @RequestMapping("/test.r")
    public String getTest(HttpServletResponse resp,String name){
        resp.setHeader("Access-Control-Allow-Origin","*");
        getListService.test01(name);
        return "ok";
    }
}
