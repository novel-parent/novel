package com.yc.novelclient.service.impl;

import com.yc.novelclient.MyException.IntroductionNovelChaptersException;
import com.yc.bean.IntroductionNovel;
import com.yc.novelclient.mapper.NovelMapper;
import com.yc.thrift.IDL.NovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LX
 * @date 2019/5/17 - 19:45
 */
@Service
public class NovelServiceImpl implements NovelService {

    @Autowired
    private NovelMapper novelMapper;

//    @Cacheable(cacheNames = "novel",key = "#nid",cacheManager = "novelChaptersRedisCacheManager")
    @Override
    public IntroductionNovel selNovelByNid(long nid) throws IntroductionNovelChaptersException {

        IntroductionNovel introductionNovel = novelMapper.selNovelByNid(nid);

        if (introductionNovel == null){
            throw new IntroductionNovelChaptersException("暂无此小说");
        }

        return introductionNovel;
    }
}
