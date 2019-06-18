package com.yc.novelclient.service;


import com.yc.novelclient.MyException.IntroductionNovelChaptersException;
import com.yc.novelclient.MyException.ReadNovelChapterContextException;
import com.yc.bean.ReadNovel;

/**
 * @author LX
 * @date 2019/5/12 - 19:19
 */
public interface VisitorNovelService {

    /**
     *        获取小说的章节列表
     * @param nid
     * @return
     * @throws IntroductionNovelChaptersException
     */
    String getIntroductionNovelChapters(long nid) throws IntroductionNovelChaptersException;

    /**
     *      获取小说章节内容
     * @param nid
     * @param cid
     * @return
     * @throws ReadNovelChapterContextException
     */
    ReadNovel getNovelChapterContext(long nid , long cid ) throws ReadNovelChapterContextException;
}
