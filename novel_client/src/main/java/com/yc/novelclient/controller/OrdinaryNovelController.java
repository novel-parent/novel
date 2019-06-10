package com.yc.novelclient.controller;

import com.yc.bean.ReadNovel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yc.novelclient.service.OrdinaryNovelService;

/**
 * @author LX
 * @date 2019/5/17 - 19:31
 */
@Controller
public class OrdinaryNovelController {

    @Autowired
    private OrdinaryNovelService ordinaryNovelService;

    @ResponseBody
    @RequestMapping(value = "/userNovelChapters.n",produces = "text/html; charset=utf-8")
    public String getNovelChapterList(@RequestParam("nid") long nid, @RequestParam("uid") String uid){

        return ordinaryNovelService.getIntroductionNovelChapters(nid, uid);
    }

    @ResponseBody
    @RequestMapping("/userReadNovelChapter.n")
    public ReadNovel getNovelChapterContext(@RequestParam("nid") long nid,
                                            @RequestParam("cid") long cid, @RequestParam("uid") String uid){
        return ordinaryNovelService.getNovelChapterContext(nid, cid, uid);
    }
}
