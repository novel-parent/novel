package com.yc.redis;

import com.yc.redis.util.RedisPoolUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;

import java.util.Set;

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

    @Test
    public void setTest(){
        Jedis jedis=new Jedis("106.14.162.109",6379);
        jedis.auth("lsx666");
//        jedis.zadd("z2",2500,"权利的游戏");
//        jedis.zadd("z2",1600,"黑狱");
//        jedis.zadd("z2",20080,"西游记");
//        jedis.zrem("z2","黑狱");
   //     jedis.zremrangeByScore("z2",0,99999);
        jedis.del("z2");
        Set<String> set= jedis.zrange("z2",0,-1);
        System.out.println(set);


        jedis.close();
    }

    @Autowired
    private RedisPoolUtil rpu;
    @Test
    public void jedisTest(){
        Jedis jedis=rpu.getJedis();
        Set<String> set=jedis.keys("*");
        System.out.println(set);
        jedis.close();
    }


}