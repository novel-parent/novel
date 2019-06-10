package com.yc.novelclient.impl;

import com.yc.novelclient.MyException.IntroductionNovelChaptersException;
import com.yc.bean.IntroductionNovel;
import com.yc.novelclient.mapper.NovelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yc.novelclient.service.NovelService;

/**
 * @author LX
 * @date 2019/5/17 - 19:45
 */
@Service
public class NovelServiceImpl implements NovelService {

    @Autowired
    private NovelMapper novelMapper;

    @Override
    public IntroductionNovel selNovelByNid(long nid) throws IntroductionNovelChaptersException {

        IntroductionNovel introductionNovel = novelMapper.selNovelByNid(nid);

        if (introductionNovel == null){
            throw new IntroductionNovelChaptersException("暂无此小说");
        }

        return introductionNovel;
    }
}
