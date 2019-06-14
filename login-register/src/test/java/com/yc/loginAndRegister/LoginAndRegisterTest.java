package com.yc.loginAndRegister;

import com.yc.loginregister.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
public class LoginAndRegisterTest {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Test
	public void rabbitMqTest(){

		User user = new User();

		user.setEmail("157922018@qq.com");

		rabbitTemplate.convertAndSend("user.login", "user.login", user);
	}



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
