package com.yc.loginregister.advice;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import com.yc.loginregister.bean.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginAfterAspect {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Pointcut("execution(* com.yc.loginregister.service.impl.UserServiceImpl.selForLogin(..))")
	public void executeService() {

	}

	@Async
	@AfterReturning(value = "executeService()", returning = "result")
	public void doAfterAdvice(JoinPoint jp, Object result) {

		// 用户已登录
		if (result != null) {
			try {

				Method method = result.getClass().getMethod("getVip");

				User user = (User) result;

				if (method.invoke(result) != null) {
					System.out.println("该用户是会员 "+ result);
				} else {
					System.out.println("该用户为普通用户");
				}
				stringRedisTemplate.opsForValue().set("user:"+user.getUid(), user.getUid()+"", 30,TimeUnit.MINUTES);

				// 用户登录成功 发送消息给  消息中间件 队列  user.login   传入 user信息
				rabbitTemplate.convertAndSend("user.login", "user.login", result);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
