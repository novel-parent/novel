package com.yc.novelclient.controller;

import com.yc.bean.IntroductionDiv;
import com.yc.bean.ReadDiv;
import com.yc.bean.ReadNovel;
import com.yc.novelclient.MyException.IntroductionNovelChaptersException;
import com.yc.novelclient.MyException.ReadNovelChapterContextException;
import com.yc.novelclient.service.VipCacheService;
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

    @Autowired
    private VipCacheService vipCacheService;

    @ResponseBody
    @RequestMapping(value = "/vipNovelChapters.n",produces = " application/json ; charset=utf-8")
    public IntroductionDiv getNovelChapterList(@RequestParam("nid") long nid, @RequestParam("uid") String uid, @RequestParam(value = "vip") boolean vip){


        long start = System.currentTimeMillis();
        IntroductionDiv introductionDiv = null ;
        String novelChapters = null;

        try {

            introductionDiv = vipNovelService.getIntroductionNovelChapters(nid,uid);
        } catch (ReadNovelChapterContextException e) {
            e.printStackTrace();
        } catch (IntroductionNovelChaptersException e) {
            e.printStackTrace();
        }

        System.out.println(System.currentTimeMillis()-start);
        return introductionDiv;
    }

    @ResponseBody
    @RequestMapping("/vipReadNovelChapter.n")
    public ReadDiv getNovelChapterContext(@RequestParam("nid") long nid,
                                          @RequestParam("cid") String cid, @RequestParam("uid") String uid, @RequestParam(value = "vip") boolean vip){

        ReadDiv readDiv = null;
        ReadNovel chapterContext = null;

        try {

            readDiv = vipNovelService.getNovelChapterContext(nid, cid, uid);
        } catch (IntroductionNovelChaptersException e) {
            e.printStackTrace();
        } catch (ReadNovelChapterContextException e) {
            e.printStackTrace();
        }

        if(readDiv != null){

            String url = readDiv.getIntroductionNovel().getUrl() + readDiv.getReadNovel().getNextChapter() + ".html";

            vipCacheService.getVipNextReadDiv(readDiv.getIntroductionNovel(),  readDiv.getReadNovel().getNextChapter(), url);
        }
        return readDiv;
    }
}
