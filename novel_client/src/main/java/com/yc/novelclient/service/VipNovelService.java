package com.yc.novelclient.service;

import com.yc.novelclient.MyException.IntroductionNovelChaptersException;
import com.yc.novelclient.MyException.ReadNovelChapterContextException;
import com.yc.bean.ReadNovel;

/**
 * @author LX
 * @date 2019/5/17 - 19:42
 */
public interface VipNovelService {

    ReadNovel getNovelChapterContext(long nid , long cid , String uid) throws IntroductionNovelChaptersException;

    String getIntroductionNovelChapters(long nid ,String uid) throws ReadNovelChapterContextException;
}
