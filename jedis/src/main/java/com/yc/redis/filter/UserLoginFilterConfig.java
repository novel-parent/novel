package com.yc.redis.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author LX
 * @date 2019/6/16 - 19:23
 */
public class UserLoginFilterConfig implements Filter {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     *
     * 再次 进行  redis 判断 用户是否登录
     *
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String uid = request.getParameter("uid");
        String flag = stringRedisTemplate.opsForValue().get("user:" + uid);
        /**
         * flag  == null   用户没有登录 或者 用户登录信息 失效
         *
         */
        if(flag == null){
            response.getWriter().write("此用户还没登录,请先登录后再进行操作");
            return ;
        }

        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }
}
