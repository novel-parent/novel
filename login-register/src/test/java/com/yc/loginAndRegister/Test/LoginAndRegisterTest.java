package com.yc.loginAndRegister.Test;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import redis.clients.jedis.Jedis;

@SpringBootTest
public class LoginAndRegisterTest {
	
	@Test
	public void test() throws InterruptedException {
		Jedis jedis=new Jedis("106.14.162.109",6379);
		jedis.auth("lsx666");
		
		
		jedis.set("a", "1");
		
		jedis.set("a","adsfs");
		
		jedis.expire("a", 5);
		
		//Thread.currentThread().sleep(6*1000);
		
		System.out.println("==============="+jedis.get("a"));
	}

}
