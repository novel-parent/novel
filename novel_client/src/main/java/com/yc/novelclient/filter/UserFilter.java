package com.yc.novelclient.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author LX
 * @date 2019/6/18 - 20:57
 */
public class UserFilter implements Filter {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String uid = request.getParameter("uid");

        if(uid==null || redisTemplate.opsForValue().get("uid:"+uid) == null){
            response.getWriter().write("该用户信息异常,请重新登陆");
            return;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
