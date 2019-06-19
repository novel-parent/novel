package com.yc.novelclient.controller;

import com.yc.bean.IntroductionDiv;
import com.yc.bean.ReadDiv;
import com.yc.novelclient.MyException.IntroductionNovelChaptersException;
import com.yc.novelclient.MyException.ReadNovelChapterContextException;
import com.yc.bean.ReadNovel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yc.novelclient.service.VisitorNovelService;


/**
 * @author LX
 * @date 2019/5/12 - 19:03
 */
@Controller
public class VisitorNovelController {

    @Autowired
    private VisitorNovelService visitorNovelService;

    @ResponseBody
    @RequestMapping("/readNovelChapter.n")
    public ReadDiv getNovelChapterContext(@RequestParam("nid") long nid, @RequestParam("cid") long cid){

        ReadDiv readDiv = null ;

        ReadNovel novelChapterContext = null;

        try {

            readDiv = visitorNovelService.getNovelChapterContext(nid, cid);

        } catch (ReadNovelChapterContextException e) {

            e.printStackTrace();
        }
        return readDiv;
    }

    @ResponseBody
    @RequestMapping(value = "/novelChapters.n",produces = " application/json ; charset=utf-8")
    public IntroductionDiv getNovelChapterList(@RequestParam("nid") long nid){

        System.out.println(nid);
        IntroductionDiv introductionDiv = null;
        try {
            introductionDiv = visitorNovelService.getIntroductionNovelChapters(nid);

            System.out.println(introductionDiv.getIntroductionNovel());
        } catch (IntroductionNovelChaptersException e) {

            e.printStackTrace();
        }
        return introductionDiv;
    }

}
