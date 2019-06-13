package com.yc.redis.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;

/**
 * @author LX
 * @date 2019/6/12 - 21:42
 */
@Controller
public class SearchListController {

    private StringRedisTemplate stringRedisTemplate;

    private RedisTemplate redisTemplate;
}
