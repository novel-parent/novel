package com.yc.user.impl;

import com.yc.user.mapper.UserCollectMapper;
import com.yc.user.myexception.CollectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yc.user.service.UserCollectService;
import util.DateUtil;

/**
 * @author LX
 * @date 2019/5/29 - 21:36
 */
@Service
public class UserCollectServiceImpl implements UserCollectService {

    @Autowired
    private UserCollectMapper userCollectMapper;

    /**
     * 用戶 收藏小說
     * @param uid  用户id
     * @param nid  小说id
     * @return
     */
    public int insCollectNovel(long uid, long nid) throws CollectException {

        int index = 0;

        try {
            index = userCollectMapper.insCollectNovel(uid, nid, DateUtil.getDate());
        } catch (Exception e) {
            //  数据库异常
            e.printStackTrace();
            throw new CollectException("用户插入小说名 收藏表失败  数据库异常");
        }
        return index;
    }

    /**
     * 用户收藏小说章节
     * @param uid
     * @param nid
     * @param cid
     * @param novelChapterName
     * @return
     */
    public int insCollectNovelChapter(long uid, long nid, long cid, String novelChapterName) throws CollectException {

        int index = 0;
        try {
            index = userCollectMapper.insCollectNovelChapter(uid, nid, cid, novelChapterName,DateUtil.getDate());
        } catch (Exception e) {
            e.printStackTrace();
            throw new CollectException("用户插入小说章节  收藏表失败  数据库异常");
        }

        return index;
    }
}
