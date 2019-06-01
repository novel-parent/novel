package controller;

import MyException.IntroductionNovelChaptersException;
import com.yc.bean.IntroductionNovel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.NovelService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author LX
 * @date 2019/5/17 - 19:44
 */
@Controller
public class NovelController {

    @Autowired
    private NovelService novelService;

    /**
     * 根据小说id  获得小说信息
     * @param nid
     * @return
     */
    @ResponseBody
    @RequestMapping("/introduction.n")
    public IntroductionNovel getIntroductionNovel(@RequestParam(value = "nid") long nid, HttpServletRequest req){

        IntroductionNovel introductionNovel = null;
        try {
            introductionNovel = novelService.selNovelByNid(nid);
        } catch (IntroductionNovelChaptersException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return introductionNovel;
    }
}
