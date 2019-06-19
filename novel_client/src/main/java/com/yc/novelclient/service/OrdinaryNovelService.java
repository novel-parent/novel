package com.yc.novelclient.service;

import com.yc.bean.ReadNovel;
import com.yc.novelclient.MyException.IntroductionNovelChaptersException;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransportException;

/**
 * @author LX
 * @date 2019/5/17 - 19:40
 */
public interface OrdinaryNovelService {

    /**
     *        普通用户  获取小说章节列表
     * @param nid
     * @param cid
     * @param uid
     * @return
     */
    ReadNovel getNovelChapterContext(long nid , long cid , String uid) throws TException, InterruptedException;

    /**
     *       普通 用户 获取 小说章节内容
     * @param nid
     * @param uid
     * @return
     */
    String getIntroductionNovelChapters(long nid ,String uid) throws TException, IntroductionNovelChaptersException;
}
