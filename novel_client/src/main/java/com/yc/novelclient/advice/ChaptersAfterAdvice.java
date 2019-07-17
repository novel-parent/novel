package com.yc.novelclient.advice;

import com.yc.novelclient.mapper.ReadMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author LX
 * @date 2019/7/17 - 19:38
 */
@Component
@Aspect
public class ChaptersAfterAdvice {

    @Autowired
    private ReadMapper readMapper;

    @Pointcut(value = "execution(* com.yc.novelclient.service.impl..*.getIntroductionNovelChapters(..))")
    public void getChapters(){}

    @AfterReturning(pointcut = "getChapters()" ,returning = "result")
    public void doAfterReturning(JoinPoint jp, Object result){

        Object[] args = jp.getArgs();

        Long nid = null;

        Object arg = args[0];

        if(arg !=null){

            nid = (Long)arg;
            updReadNumber(nid);
        }else {
            return;
        }
    }


    public void updReadNumber(long nid){

        int i = readMapper.selReadNumber(nid);

        if(i>0){

            readMapper.updReadNumber(nid);
        }else{
            readMapper.insReadNumber(nid);
        }
    }
}
