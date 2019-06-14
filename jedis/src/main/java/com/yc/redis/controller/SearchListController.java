package com.yc.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @author LX
 * @date 2019/6/12 - 21:42
 */
@RestController
public class SearchListController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 获取搜索排行榜前30
     */
    @PostMapping("/getSearchList")
    public Set<String> getSearchList(){
        redisTemplate.opsForZSet().add("z1","斗罗大陆",8000);
        redisTemplate.opsForZSet().add("z1","斗破苍穹",10999);
        redisTemplate.opsForZSet().add("z1","完美世界",8924);

        Set<String> set=redisTemplate.opsForZSet().range("z1",0,100000);
        System.out.println(set);

        return null;
    }






}
