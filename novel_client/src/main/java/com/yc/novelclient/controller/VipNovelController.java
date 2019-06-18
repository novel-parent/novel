package com.yc.novelclient.controller;

import com.yc.novelclient.MyException.IntroductionNovelChaptersException;
import com.yc.novelclient.MyException.ReadNovelChapterContextException;
import com.yc.novelclient.service.VipNovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author LX
 * @date 2019/5/16 - 20:49
 */
@Controller
public class VipNovelController {
    
    @Autowired
    private VipNovelService vipNovelService;

    @ResponseBody
    @RequestMapping(value = "/vipNovelChapters.n",produces = "text/html; charset=utf-8")
    public String getNovelChapterList(@RequestParam("nid") long nid,@RequestParam("uid") String uid,@RequestParam(value = "vip") boolean vip){

        String novelChapters = null;

        try {

            novelChapters = vipNovelService.getIntroductionNovelChapters(nid);
        } catch (ReadNovelChapterContextException e) {
            e.printStackTrace();
        }

        return novelChapters;
    }

    @ResponseBody
    @RequestMapping("/vipReadNovelChapter.n")
    public com.yc.bean.ReadNovel getNovelChapterContext(@RequestParam("nid") long nid,
                                                        @RequestParam("cid") long cid, @RequestParam("uid") String uid, @RequestParam(value = "vip") boolean vip){

        com.yc.bean.ReadNovel chapterContext = null;

        try {

            chapterContext = vipNovelService.getNovelChapterContext(nid, cid, uid);
        } catch (IntroductionNovelChaptersException e) {
            e.printStackTrace();
        }

        return chapterContext;
    }
}
