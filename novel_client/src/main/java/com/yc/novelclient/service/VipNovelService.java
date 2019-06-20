package com.yc.novelclient.service;

import com.yc.bean.IntroductionDiv;
import com.yc.bean.ReadDiv;
import com.yc.novelclient.MyException.IntroductionNovelChaptersException;
import com.yc.novelclient.MyException.ReadNovelChapterContextException;
import com.yc.bean.ReadNovel;

/**
 * @author LX
 * @date 2019/5/17 - 19:42
 */
public interface VipNovelService {

    /**
     * vip 用户获得小说章节内容
     * @param nid
     * @param cid
     * @param uid
     * @return
     * @throws IntroductionNovelChaptersException
     * @throws ReadNovelChapterContextException
     */
    ReadDiv getNovelChapterContext(long nid , String cid , String uid) throws IntroductionNovelChaptersException, ReadNovelChapterContextException;

    /**
     *         vip 用户获取 小说章节列表
     * @param nid
     * @param uid
     * @return
     * @throws ReadNovelChapterContextException
     * @throws IntroductionNovelChaptersException
     */
    IntroductionDiv getIntroductionNovelChapters(long nid , String uid) throws ReadNovelChapterContextException, IntroductionNovelChaptersException;
}
