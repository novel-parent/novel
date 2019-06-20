package com.yc.novelclient.controller;

import com.yc.bean.ReadNovel;
import com.yc.novelclient.MyException.IntroductionNovelChaptersException;
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
    @RequestMapping(value = "/userNovelChapters.n",produces = "text/html; charset=utf-8")
    public String getNovelChapterList(@RequestParam("nid") long nid, @RequestParam("uid") String uid){

        String msg = "-1";
        try {
            msg = ordinaryNovelService.getIntroductionNovelChapters(nid, uid);
        } catch (TException e) {
            e.printStackTrace();
        } catch (IntroductionNovelChaptersException e) {
            e.printStackTrace();
        }
        return msg;
    }

    @ResponseBody
    @RequestMapping("/userReadNovelChapter.n")
    public ReadNovel getNovelChapterContext(@RequestParam("nid") long nid,
                                            @RequestParam("cid") long cid, @RequestParam("uid") String uid){

        ReadNovel context = null ;

        try {

            context = ordinaryNovelService.getNovelChapterContext(nid, cid, uid);
        } catch (TException e) {

            e.printStackTrace();
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        return context;
    }
}
