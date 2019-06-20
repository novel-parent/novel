package com.yc.novelclient.controller;

import com.yc.bean.IntroductionDiv;
import com.yc.bean.ReadDiv;
import com.yc.bean.ReadNovel;
import com.yc.novelclient.MyException.IntroductionNovelChaptersException;
import com.yc.novelclient.MyException.ReadNovelChapterContextException;
import org.apache.thrift.TException;
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
    @RequestMapping(value = "/userNovelChapters.n",produces = " application/json ; charset=utf-8")
    public IntroductionDiv getNovelChapterList(@RequestParam("nid") long nid, @RequestParam("uid") String uid){

        long start = System.currentTimeMillis();
        IntroductionDiv introductionDiv = null;

        try {
            introductionDiv = ordinaryNovelService.getIntroductionNovelChapters(nid, uid);
        } catch (TException e) {

            e.printStackTrace();
        } catch (IntroductionNovelChaptersException e) {

            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis()-start);
        return introductionDiv;
    }

    @ResponseBody
    @RequestMapping("/userReadNovelChapter.n")
    public ReadDiv getNovelChapterContext(@RequestParam("nid") long nid,
                                          @RequestParam("cid") long cid, @RequestParam("uid") String uid){

        ReadDiv readDiv = null;
        ReadNovel context = null ;

        try {

            readDiv = ordinaryNovelService.getNovelChapterContext(nid, cid, uid);
        } catch (TException e) {

            e.printStackTrace();
        } catch (InterruptedException e) {

            e.printStackTrace();
        } catch (ReadNovelChapterContextException e) {
            e.printStackTrace();
        }
        return readDiv;
    }
}
