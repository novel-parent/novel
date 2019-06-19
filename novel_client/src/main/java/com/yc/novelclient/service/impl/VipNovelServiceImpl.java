package com.yc.novelclient.service.impl;

import com.yc.novelclient.MyException.IntroductionNovelChaptersException;
import com.yc.novelclient.MyException.ReadNovelChapterContextException;
import com.yc.bean.ReadNovel;
import com.yc.novelclient.mapper.NovelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yc.novelclient.service.VipNovelService;
import util.ThreadPollUtil;

import java.util.concurrent.ExecutorService;

/**
 * @author LX
 * @date 2019/5/17 - 19:42
 */
@Service
public class VipNovelServiceImpl implements VipNovelService {

    @Autowired
    private NovelMapper novelMapper;

    private ExecutorService executorService = ThreadPollUtil.executorService;

    @Override
    public ReadNovel getNovelChapterContext(long nid, long cid, String uid) throws IntroductionNovelChaptersException {

        ReadNovel readNovel = null ;

        return readNovel;
    }


    @Override
    public String getIntroductionNovelChapters(long nid, String uid) throws ReadNovelChapterContextException {

        String novelChapterListJson = null;

        return novelChapterListJson;
    }
}
