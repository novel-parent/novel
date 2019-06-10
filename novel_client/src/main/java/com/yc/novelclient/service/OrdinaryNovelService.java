package com.yc.novelclient.service;

import com.yc.bean.ReadNovel;

/**
 * @author LX
 * @date 2019/5/17 - 19:40
 */
public interface OrdinaryNovelService {

    ReadNovel getNovelChapterContext(long nid , long cid , String uid);

    String getIntroductionNovelChapters(long nid ,String uid);
}
