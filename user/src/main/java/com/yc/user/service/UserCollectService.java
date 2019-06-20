package com.yc.user.service;

import com.yc.user.bean.Collect;
import com.yc.user.myexception.CollectException;

import java.util.List;

/**
 * @author LX
 * @date 2019/5/29 - 21:35
 */
public interface UserCollectService {

    /**
     *     用户收藏   小说名字
     * @param uid
     * @param nid
     * @return
     * @throws CollectException
     */
    int insCollectNovel(long uid,long nid) throws CollectException;

    /**
     *      用户收藏小说章节
     * @param uid
     * @param nid
     * @param cid
     * @param novelChapterName
     * @return
     * @throws CollectException
     */
    int insCollectNovelChapter(long uid,long nid ,long cid,String novelChapterName) throws CollectException;

    /**
     * 用户 获取的  收藏 信息
     * @param uid
     * @return
     */
    List<Collect> selUserCollectList(long uid);
}
