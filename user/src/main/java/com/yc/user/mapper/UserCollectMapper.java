package com.yc.user.mapper;

import com.yc.user.bean.Collect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author LX
 * @date 2019/5/29 - 21:39
 */
public interface UserCollectMapper {

    /**
     *       查询 收藏表是否存在该用户已经  投了票的
     * @param uid
     * @param nid
     * @return
     */
    Collect selByUidNid(@Param("uid") long uid , @Param("nid") long nid);

    /**
     *          插入 nid
     * @param uid
     * @param nid
     * @param cTimes
     * @return
     */
    int insCollectNovel(@Param("uid") long uid,@Param("nid") long nid,@Param("cTimes") String cTimes);

    /**
     *     插入 nid  和 小说名  和 cid
     * @param uid
     * @param nid
     * @param cid
     * @param novelChapterName
     * @param cTimes
     * @return
     */
    int insCollectNovelChapter(@Param("uid") long uid,@Param("nid") long nid,@Param("cid") long cid,@Param("novelChapterName") String novelChapterName,@Param("cTimes") String cTimes);

    /**
     *     查询用户收藏书籍 信息
     * @param uid
     * @return
     */
    List<Collect> selUserCollectList(@Param("uid") long uid);
}
