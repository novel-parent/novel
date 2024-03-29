package com.yc.novelclient.filter;

import redis.clients.jedis.Jedis;
import com.yc.novelclient.util.RedisPoolUtil;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author LX
 * @date 2019/6/18 - 20:57
 */
public class UserFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        long start = System.currentTimeMillis();

        String uid = request.getParameter("uid");

        Jedis jedis = RedisPoolUtil.getJedis();

        if(uid == null || jedis.get( "user:"+uid ) == null ){
            response.getWriter().write("-1");

            jedis.close();

            System.out.println(System.currentTimeMillis()-start);
            return;
        }

        jedis.close();
        System.out.println(System.currentTimeMillis()-start);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
