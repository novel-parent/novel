package com.yc.user.service;

import com.yc.user.bean.Novel;
import com.yc.user.mapper.NovelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GetListService {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private NovelMapper novelMapper;

    public String addNoveltolist(String key,String novelName,double db){
        Novel nv=novelMapper.selectNovelByName(novelName);
        Set<Novel> set=new HashSet<Novel>();
        set.add(nv);
        redisTemplate.opsForZSet().add(key,set,db);
        return "添加成功";
    }

    /**
     * 获取搜索排行榜前30
     * Ranking:search
     */
    public Map<String,Object> getSearchList(){
    //    Set<String> set=redisTemplate.opsForZSet().reverseRangeByScore("Ranking:search",0,99999999,0,30);
        Set<ZSetOperations.TypedTuple<Object>> set2=redisTemplate.opsForZSet().reverseRangeByScoreWithScores("Ranking:search",0,99999999,0,30);
        System.out.println("set::"+set2);
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
    public Map<String,Object> getConlectionList(){
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
    public Map<String,Object> getRecommendList(){
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
    public Map<String,Object> SettoMap(Set<ZSetOperations.TypedTuple<Object>> set){
        Iterator i=set.iterator();
        Map<String,Object> map=new LinkedHashMap<String, Object>();
        while (i.hasNext()){
            ZSetOperations.TypedTuple<Object> typedTuple = (ZSetOperations.TypedTuple<Object> )i.next();
            Object value = typedTuple.getValue();
            String score = ""+typedTuple.getScore();
            map.put(score,value);
        }
        return map;
    }

    /**
     * 测试
     */
    public Double getTest(){
        ///////取0—9999999范围内的小到大，0开始的前2个值
        Set<String> set=redisTemplate.opsForZSet().rangeByScore("z1",0,99999999,0,2);
        ///////取0—9999999范围内的大到小，0开始的前2个值
        set=redisTemplate.opsForZSet().reverseRangeByScore("z1",0,99999999,0,2);
        ////// 返回指定元素的分数
        Double db=redisTemplate.opsForZSet().score("z1","斗罗大陆");

        return db;
    }

}
