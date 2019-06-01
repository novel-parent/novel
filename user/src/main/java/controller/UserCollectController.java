package controller;

import myexception.CollectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserCollectService;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * @author LX
 * @date 2019/5/29 - 21:32
 */
@Controller
public class UserCollectController {

    @Autowired
    private UserCollectService userCollectService;

    @ResponseBody
    @RequestMapping("userCollectNovel.u")
    public int collectNovel(@RequestParam("uid") long uid, @RequestParam("nid") long nid, HttpServletResponse resp){

        resp.setHeader("Access-Control-Allow-Origin","*");
        int index = 0;
        try {
            index = userCollectService.insCollectNovel(uid, nid);
        } catch (CollectException e) {
            e.printStackTrace();
        }

        return index;
    }

    @ResponseBody
    @RequestMapping(value = "userCollectNovelChapter.u")
    public int collectNovelChapter(@RequestParam("uid")long uid,@RequestParam("nid")long nid,@RequestParam("cid")long cid
            ,@RequestParam("novelChapterName") String novelChapterName,HttpServletResponse resp){

        resp.setHeader("Access-Control-Allow-Origin","*");
        int index = 0;

        try {

             index = userCollectService.insCollectNovelChapter(uid, nid, cid, novelChapterName);
         }catch (CollectException e) {
            e.printStackTrace();
        }
        return index;
    }

}
