package com.yc.loginregister.filter;


import redis.clients.jedis.Jedis;

import javax.servlet.*;
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


        Jedis jedis = new Jedis();

        jedis.auth("");

        System.out.println("拦截登录   ");
        String username = request.getParameter("username");
        System.out.println(username);

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

}
