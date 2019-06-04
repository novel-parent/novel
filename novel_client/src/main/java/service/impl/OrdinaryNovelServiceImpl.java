package service.impl;

import com.yc.bean.ReadNovel;
import com.yc.thrift.client.OrdinaryUserThriftClient;
import com.yc.util.RedisPoolUtil;
import mapper.NovelMapper;
import mapper.OrdinaryNovelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import service.OrdinaryNovelService;
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
    public ReadNovel getNovelChapterContext(long nid, long cid, String uid) {

        Jedis jedis = RedisPoolUtil.getJedis();

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
    public String getIntroductionNovelChapters(long nid, String uid) {
        Jedis jedis = RedisPoolUtil.getJedis();

        if(jedis.exists("user:"+uid)){
            // 如果用户登陆 了

        }else {
            //登录信息过期
        }

        return null;
    }
}
