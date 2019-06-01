package controller;

import MyException.IntroductionNovelChaptersException;
import MyException.ReadNovelChapterContextException;
import com.yc.bean.ReadNovel;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.VisitorNovelService;


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
    public ReadNovel getNovelChapterContext(@RequestParam("nid") long nid, @RequestParam("cid") long cid){
        ReadNovel novelChapterContext = null;

        try {

            novelChapterContext = visitorNovelService.getNovelChapterContext(nid, cid);
        } catch (ReadNovelChapterContextException e) {

            e.printStackTrace();
        }
        return novelChapterContext;
    }

    @ResponseBody
    @RequestMapping(value = "/novelChapters.n",produces = "text/html; charset=utf-8")
    public String getNovelChapterList(@RequestParam("nid") long nid){

        String novelChapters = null;

        try {
            novelChapters = visitorNovelService.getIntroductionNovelChapters(nid);
        } catch (IntroductionNovelChaptersException e) {

            e.printStackTrace();
        }
        return novelChapters;
    }

}
