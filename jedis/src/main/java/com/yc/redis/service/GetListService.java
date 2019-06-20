package com.yc.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * 获取搜索排行榜前30
     * Ranking:search
     */
    public Map<String,Map> getSearchList(){
    //    Set<String> set=redisTemplate.opsForZSet().reverseRangeByScore("Ranking:search",0,99999999,0,30);
        Set<ZSetOperations.TypedTuple<Object>> set2=redisTemplate.opsForZSet().reverseRangeByScoreWithScores("Ranking:search",0,99999999,0,30);
        return SettoMap(set2);
    }

    /**
     * 更新搜索排行榜
     * Ranking:search
     */
    public void updateSearchList(String name){
        //返回指定成员分数
        Double db=redisTemplate.opsForZSet().score("Ranking:search",name);
        redisTemplate.opsForZSet().add("Ranking:search",name,db+1);
    }

    /**
     * 获取收藏排行榜前30
     * Ranking:conlection
     */
    public Map<String,Map> getConlectionList(){
        Set<ZSetOperations.TypedTuple<Object>> set=redisTemplate.opsForZSet().reverseRangeByScoreWithScores("Ranking:conlection",0,99999999,0,30);
        return SettoMap(set);
    }

    /**
     * 更新收藏排行榜
     * Ranking:conlection
     */
    public void updateConlectionList(String name){
        //返回指定成员分数
        Double db=redisTemplate.opsForZSet().score("Ranking:conlection",name);
        redisTemplate.opsForZSet().add("Ranking:conlection",name,db+1);
    }

    /**
     * 获取推荐排行榜前30
     * Ranking:recommend
     */
    public Map<String,Map> getRecommendList(){
        Set<ZSetOperations.TypedTuple<Object>> set=redisTemplate.opsForZSet().reverseRangeByScoreWithScores("Ranking:recommend",0,99999999,0,30);
        return SettoMap(set);
    }

    /**
     * 更新推荐排行榜
     * Ranking:recommend
     */
    public void updateRecommendList(String name){
        //返回指定成员分数
        Double db=redisTemplate.opsForZSet().score("Ranking:recommend",name);
        redisTemplate.opsForZSet().add("Ranking:recommend",name,db+1);
    }

    /**
     * 将ZSetOperations.TypedTuple<Object> 转为Map<String,Object>键值对
     */
    public Map<String,Map> SettoMap(Set<ZSetOperations.TypedTuple<Object>> set){
        Map<String,Map> M=new LinkedHashMap<String, Map>();
        Iterator it=set.iterator();
        while (it.hasNext()){
            ZSetOperations.TypedTuple<Object> typedTuple = (ZSetOperations.TypedTuple<Object> )it.next();
            List<Map> value =  (List<Map>) typedTuple.getValue();
            String score = ""+typedTuple.getScore();
            M.put(score,value.get(0));
        }
        return M;
    }

    /**
     * 测试
     */
    public Map<String,Map> getTest(){
        Map<String,Map> M=new LinkedHashMap<String, Map>();
        Set<ZSetOperations.TypedTuple<Object>> set=redisTemplate.opsForZSet().reverseRangeByScoreWithScores("Ranking:search",0,99999999,0,30);
        Iterator<ZSetOperations.TypedTuple<Object>> it=set.iterator();
        while(it.hasNext()){
            ZSetOperations.TypedTuple<Object> typedTuple = (ZSetOperations.TypedTuple<Object> )it.next();
            List<Map> value =  (List<Map>) typedTuple.getValue();
            System.err.println(value.get(0).get("novelName"));
            String score = ""+typedTuple.getScore();
            M.put(score,value.get(0));
        }
        return M;
    }

}
