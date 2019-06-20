package com.yc.novelclient.service.impl;

import com.yc.bean.IntroductionNovel;
import com.yc.bean.ReadNovel;
import com.yc.novelclient.MyException.IntroductionNovelChaptersException;
import com.yc.novelclient.mapper.NovelMapper;
import com.yc.novelclient.service.OrdinaryNovelService;
import com.yc.thrift.client.OrdinaryUserThriftClient;
import com.yc.thrift.client.UserThriftClient;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransportException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import util.OrdinaryUtil;

import java.util.HashMap;

/**
 * @author LX
 * @date 2019/5/17 - 19:40
 */
@Service
public class OrdinaryNovelServiceImpl implements OrdinaryNovelService {

    @Autowired
    private NovelMapper novelMapper;

    private HashMap<String,OrdinaryUserThriftClient> ordinaryUserThriftClientHashMap
            = OrdinaryUtil.ordinaryUserThriftClientHashMap;

    @Override
    public ReadNovel getNovelChapterContext(long nid, long cid, String uid) throws TException, InterruptedException {

        IntroductionNovel novel = novelMapper.selNovelByNid(nid);

        String url = novel.getUrl()+cid+".html";

        UserThriftClient client = new UserThriftClient();

        ReadNovel context = client.getNovelChapterContextByChapterUrl(url);

        client.getTransport().close();

        if(context == null){
            throw new InterruptedException("用户获取小说章节出错");
        }

        return context;
    }

    @Override
    public String getIntroductionNovelChapters(long nid, String uid) throws TException, IntroductionNovelChaptersException {

        IntroductionNovel introductionNovel = novelMapper.selNovelByNid(nid);

        UserThriftClient thriftClient = new UserThriftClient();

        String chapterList = thriftClient.getNovelChapterListByNovelUrl(introductionNovel.getUrl());

        thriftClient.getTransport().close();

        if (chapterList == null){
            throw new IntroductionNovelChaptersException("获得小说章节列表出错");
        }

        return chapterList;
    }
}
