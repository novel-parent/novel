package com.yc.redis.service;

import com.yc.redis.bean.CollectDiv;
import com.yc.redis.mapper.ListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GetListService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private ListMapper listMapper;

    public Set<String> selSearchHistory(){
        Set<String> list=stringRedisTemplate.opsForZSet().reverseRangeByScore("searchHistory",0,999999999,0,6);
        return list;
    }

    /*  更新搜索排行榜
    public void updateSearchList(String name){
        //返回指定成员分数
        Double db=redisTemplate.opsForZSet().score("Ranking:search",name);
        redisTemplate.opsForZSet().add("Ranking:search",name,db+1);
    }*/

    @Cacheable(cacheNames = "hot",key = "#read",cacheManager = "novelListRedisCacheManager")
    public List<CollectDiv> getReadList(String read){

        // redis 里面没有
        List<CollectDiv> divs = listMapper.selReadForHotList();

        return divs;
    }

    @Cacheable(cacheNames = "hot",key = "#collection",cacheManager = "novelListRedisCacheManager")
    public List<CollectDiv> getCollectionList(String collection){

            // redis 里面没有
            List<CollectDiv> divs = listMapper.selCollectForHotList();

            return divs;
    }

    @Cacheable(cacheNames = "hot",key = "#vote",cacheManager = "novelListRedisCacheManager")
    public List<CollectDiv> getRecommendList(String vote){
        // redis 里面没有
        List<CollectDiv> divs = listMapper.selVoteForHotList();
        return divs;
    }

    public void test01(String key){
        stringRedisTemplate.opsForZSet().incrementScore("searchHistory",key,1);
    }
}
