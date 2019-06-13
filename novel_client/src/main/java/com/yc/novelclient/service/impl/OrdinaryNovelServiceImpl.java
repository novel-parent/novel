package com.yc.novelclient.service.impl;

import com.yc.bean.ReadNovel;
import com.yc.novelclient.mapper.NovelMapper;
import com.yc.novelclient.mapper.OrdinaryNovelMapper;
import com.yc.novelclient.service.OrdinaryNovelService;
import com.yc.thrift.client.OrdinaryUserThriftClient;
import org.springframework.beans.factory.annotation.Autowired;
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
    private OrdinaryNovelMapper ordinaryNovelMapper;
    @Autowired
    private NovelMapper novelMapper;

    private HashMap<String,OrdinaryUserThriftClient> ordinaryUserThriftClientHashMap
            = OrdinaryUtil.ordinaryUserThriftClientHashMap;
    /**
     * 普通用户 访问 小说章节信息
     * @param nid
     * @param cid
     * @param uid
     * @return
     */
    @Override
    public ReadNovel getNovelChapterContext(long nid, long cid, String uid) {

        Jedis jedis = new Jedis("47.106.110.16",6379);
//      密码
//        jedis.auth("li157922018");
        jedis.auth("li157922018");

        if(jedis.exists("user:"+uid)){
            // 如果用户登陆 了

        }else {
            //登录信息过期
        }

        return null;
    }

    /**
     *  普通用户登陆   获得小说介绍页面的章节信息
     * @param nid
     * @param uid
     * @return
     */
    @Override
    public String getIntroductionNovelChapters(long nid, String uid) {
        Jedis jedis = new Jedis("47.106.110.16",6379);
//      密码
//        jedis.auth("li157922018");
        jedis.auth("li157922018");

        if(jedis.exists("user:"+uid)){
            // 如果用户登陆 了

        }else {
            //登录信息过期
        }

        return null;
    }
}
