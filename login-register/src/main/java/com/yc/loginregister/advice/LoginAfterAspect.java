package com.yc.loginregister.advice;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginAfterAspect {

	@Pointcut("execution(* com.yc.loginregister.service.impl..*.selForLogin(..))")
	public void executeService() {

	}

	@Async
	@AfterReturning(value = "executeService()", returning = "result")
	public void doBeforeAdvice(JoinPoint jp, Object result) {

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 用户已登录
		if (result != null) {
			try {

				Method method = result.getClass().getMethod("getVip");

				if (method.invoke(result) != null) {
					System.out.println("该用户是会员");
				} else {
					System.out.println("该用户为普通用户");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
