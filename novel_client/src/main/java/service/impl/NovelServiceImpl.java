package service.impl;

import MyException.IntroductionNovelChaptersException;
import com.yc.bean.IntroductionNovel;
import mapper.NovelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.NovelService;

/**
 * @author LX
 * @date 2019/5/17 - 19:45
 */
@Service
public class NovelServiceImpl implements NovelService {

    @Autowired
    private NovelMapper novelMapper;

    public IntroductionNovel selNovelByNid(long nid) throws IntroductionNovelChaptersException {

        IntroductionNovel introductionNovel = novelMapper.selNovelByNid(nid);

        if (introductionNovel == null){
            throw new IntroductionNovelChaptersException("暂无此小说");
        }

        return introductionNovel;
    }
}
