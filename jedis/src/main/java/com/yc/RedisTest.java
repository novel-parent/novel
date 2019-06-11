package com.yc;

import com.yc.util.RedisPoolUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author LX
 * @date 2019/5/15 - 21:08
 */
public class RedisTest {

    @Test
    public void test(){

        Jedis jedis = new Jedis("47.106.110.16",6379);
//      密码
        jedis.auth("li157922018");

        System.out.println(jedis.ping());
    }

    @Test
    public void poolTest(){

        Jedis jedis = RedisPoolUtil.getJedis();

        System.out.println(jedis.get("vip:1"));

        RedisPoolUtil.close(jedis);
    }

    public void hashTest(){
        Jedis jedis = RedisPoolUtil.getJedis();

        RedisPoolUtil.close(jedis);
    }
}