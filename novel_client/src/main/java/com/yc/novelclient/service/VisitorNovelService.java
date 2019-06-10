package com.yc.novelclient.service;


import com.yc.novelclient.MyException.IntroductionNovelChaptersException;
import com.yc.novelclient.MyException.ReadNovelChapterContextException;
import com.yc.bean.ReadNovel;

/**
 * @author LX
 * @date 2019/5/12 - 19:19
 */
public interface VisitorNovelService {

    String getIntroductionNovelChapters(long nid) throws IntroductionNovelChaptersException;

    ReadNovel getNovelChapterContext(long nid , long cid ) throws ReadNovelChapterContextException;
}
