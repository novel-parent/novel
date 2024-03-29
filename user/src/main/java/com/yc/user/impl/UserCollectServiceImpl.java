package com.yc.user.impl;

import com.yc.user.bean.Collect;
import com.yc.user.mapper.UserCollectMapper;
import com.yc.user.mapper.VoteMapper;
import com.yc.user.myexception.CollectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yc.user.service.UserCollectService;
import com.yc.novelclient.util.DateUtil;

import java.util.List;

/**
 * @author LX
 * @date 2019/5/29 - 21:36
 */
@Service
public class UserCollectServiceImpl implements UserCollectService {

    @Autowired
    private VoteMapper voteMapper;

    @Autowired
    private UserCollectMapper userCollectMapper;

    @Override
    public int voteVoteNovel(long nid) {

        int i = updVoteNumber(nid);

        return i;
    }

    @Override
    public int insCollectNovel(long uid, long nid) throws CollectException {

        int index = 0 ;

        try {
            Collect collect = userCollectMapper.selByUidNid(uid, nid);


            if(collect!=null){

                return -1;
            }
            index = userCollectMapper.insCollectNovel(uid, nid, DateUtil.getDate());

            updCollectNumber(nid);
        } catch (Exception e) {
            //  数据库异常
            e.printStackTrace();
            throw new CollectException("用户插入小说名 收藏表失败  数据库异常");
        }
        return index;
    }

    @Override
    public List<Collect> selUserCollectList(long uid) {

        List<Collect> collectList = null ;

        collectList = userCollectMapper.selUserCollectList(uid);

        return collectList;
    }

    @Override
    public int insCollectNovelChapter(long uid, long nid, long cid, String novelChapterName) throws CollectException {

        int index = 0;

        try {

            Collect collect = userCollectMapper.selByUidNid(uid, nid);

            if(collect ==null){

                index = userCollectMapper.insCollectNovelChapter(uid, nid, cid, novelChapterName,DateUtil.getDate());

                updCollectNumber(nid);
            }else {

                if(collect.getCid()==cid){

                    return -1;
                }

                index = userCollectMapper.updCollectByUidAndNid(uid, nid, cid,
                        novelChapterName, DateUtil.getDate());
                updCollectNumber(nid);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new CollectException("用户插入小说章节  收藏表失败  数据库异常");
        }

        return index;
    }

    public void updCollectNumber(long nid){

        Long aLong = voteMapper.selVoteNumber(nid);

        if(aLong!=null){

            userCollectMapper.updCollectNumber(nid);
        }else{
            userCollectMapper.insCollectNumber(nid);
        }


    }

    public int updVoteNumber(long nid){

        Long tNid = voteMapper.selVoteNumber(nid);

        int i = -1;

        if( tNid!= null ){

            i = voteMapper.updVoteNumber(nid);

        }else{
            i= voteMapper.insVoteNumber(nid);
        }
        return i;
    }
}
