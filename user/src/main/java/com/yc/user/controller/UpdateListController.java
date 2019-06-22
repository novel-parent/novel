package com.yc.user.controller;

import com.yc.user.service.GetListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateListController {
    @Autowired
    private GetListService getListService;

    /**
     * 更新搜索
     */
    @RequestMapping("updateSearchList.r")
    public void updateSearchList(String bookName){

        getListService.updateSearchList(bookName);
    }

    /**
     * 更新搜索
     */
    @RequestMapping("updateConlectionList.r")
    public void updateConlectionList(String bookName){

        getListService.updateConlectionList(bookName);
    }

    /**
     * 更新推荐
     */
    @RequestMapping("updateRecommendList.r")
    public void updateRecommendList(String bookName){

        getListService.updateRecommendList(bookName);
    }

    /**
     * 向redis添加小说，有记录
     */
    @RequestMapping("snovel")
    public String addNoveltolist(String novelName,@RequestParam("db") double db){
        return getListService.addNoveltolist("Ranking:conlection",novelName,db);
    }

}
