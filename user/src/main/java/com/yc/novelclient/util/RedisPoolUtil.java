package com.yc.novelclient.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author LX
 * @date 2019/5/15 - 23:28
 */
public class RedisPoolUtil {

    private static JedisPool jedisPool;

    static {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

        // 最大连接数
        jedisPoolConfig.setMaxTotal(30);
        // 最大空闲数
        jedisPoolConfig.setMaxIdle(1);
        // 连接池
        String host ="106.14.162.109";

        int port = 6379 ;

        jedisPool = new JedisPool(jedisPoolConfig,host,port);
    }

    public static Jedis getJedis(){

        Jedis jedis = jedisPool.getResource();

        jedis.auth("lsx666");

        return jedis;
    }

    public static void close(Jedis jedis){

        jedis.close();
    }
}
