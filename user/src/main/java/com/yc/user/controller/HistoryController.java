package com.yc.user.controller;

import com.yc.user.bean.HistorySearch;
import com.yc.user.myexception.SearchHistoryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yc.user.service.HistoryService;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author LX
 * @date 2019/5/26 - 21:44
 */
@Controller
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    /**
     *   搜索栏 搜索栏的 历史记录提示
     * @param uid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "userSearchHistory.u")
    public List<HistorySearch> getSearchHistory(@RequestParam("uid") long uid, HttpServletResponse resp){
        // 跨域请求
        resp.setHeader("Access-Control-Allow-Origin","*");


        List<HistorySearch> searchList = null;
        try {

            searchList = historyService.selForSearchHistory(uid);
        } catch (SearchHistoryException e) {

            e.printStackTrace();
        }
        return searchList;
    }

    @ResponseBody
    @RequestMapping("insHistory.u")
    public String insHistory(@RequestParam("uid") long uid ,@RequestParam("key") String key,HttpServletResponse resp){
        // 跨域请求
        resp.setHeader("Access-Control-Allow-Origin","*");
        String message = "-1";
        try {
            key = java.net.URLDecoder.decode(key, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            message = "-2";
        }
        int index = historyService.insHistory(uid, key);

        if(index>0){
            message = "1";
        }

        return message;
    }

}
