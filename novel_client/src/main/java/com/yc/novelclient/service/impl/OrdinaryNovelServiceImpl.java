package com.yc.novelclient.service.impl;

import com.yc.bean.ReadNovel;
import com.yc.novelclient.mapper.NovelMapper;
import com.yc.novelclient.service.OrdinaryNovelService;
import com.yc.thrift.client.OrdinaryUserThriftClient;
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
    private RedisTemplate redisTemplate;

    @Autowired
    private NovelMapper novelMapper;

    private HashMap<String,OrdinaryUserThriftClient> ordinaryUserThriftClientHashMap
            = OrdinaryUtil.ordinaryUserThriftClientHashMap;

    @Override
    public ReadNovel getNovelChapterContext(long nid, long cid, String uid) {


        return null;
    }

    @Override
    public String getIntroductionNovelChapters(long nid, String uid) {

        return null;
    }
}
