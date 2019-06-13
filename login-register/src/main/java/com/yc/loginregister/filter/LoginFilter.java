package com.yc.loginregister.filter;


import javax.servlet.*;

import com.alibaba.fastjson.JSON;
import com.yc.loginregister.bean.JsonModel;

import redis.clients.jedis.Jedis;

import java.io.IOException;

/**
 * @author LX
 * @date 2019/6/13 - 17:57
 */
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    	Jedis jedis=new Jedis("106.14.162.109",6379);
    	
    	jedis.auth("lsx666");
    	
    	JsonModel jm=new JsonModel();
    	
        String username = request.getParameter("username");
        
        String loginNum="num:"+username;
        
        String lock="lock:"+username;
        
        if(jedis.exists(lock)) {
        	
        	jm.setCode(0).setMsg("您已登录失败5次请"+jedis.ttl(lock)+"秒后再来");
        }else {
        	
        	if(jedis.exists(loginNum)) {
        		
            	jedis.incr(loginNum);
            }else {
            	jedis.set(loginNum, "0");
                
                jedis.expire(loginNum, 60*3);
            }
            
            if(Integer.valueOf(jedis.get(loginNum))<=4) {
            	
            	chain.doFilter(request, response);
            	
            	return ;
            	
            }
            	
            	jedis.set(lock, username);
            	
            	jedis.expire(lock, 60);
            	
            	jedis.del(loginNum);
            	
        }
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(JSON.toJSONString("您已登录失败5次请"+jedis.ttl(lock)+"秒后再来"));
        
    }

    @Override
    public void destroy() {

    }

}
