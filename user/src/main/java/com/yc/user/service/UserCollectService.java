package com.yc.user.service;

import com.yc.user.myexception.CollectException;

/**
 * @author LX
 * @date 2019/5/29 - 21:35
 */
public interface UserCollectService {

    int insCollectNovel(long uid,long nid) throws CollectException;

    int insCollectNovelChapter(long uid,long nid ,long cid,String novelChapterName) throws CollectException;
}
