package controller;

import MyException.IntroductionNovelChaptersException;
import MyException.ReadNovelChapterContextException;
import com.yc.bean.ReadNovel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.VipNovelService;

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

            novelChapters = vipNovelService.getIntroductionNovelChapters(nid, uid);
        } catch (ReadNovelChapterContextException e) {
            e.printStackTrace();
        }

        return novelChapters;
    }

    @ResponseBody
    @RequestMapping("/vipReadNovelChapter.n")
    public ReadNovel getNovelChapterContext(@RequestParam("nid") long nid,
                                            @RequestParam("cid") long cid, @RequestParam("uid") String uid,@RequestParam(value = "vip") boolean vip){

        ReadNovel chapterContext = null;

        try {

            chapterContext = vipNovelService.getNovelChapterContext(nid, cid, uid);
        } catch (IntroductionNovelChaptersException e) {
            e.printStackTrace();
        }

        return chapterContext;
    }
}
