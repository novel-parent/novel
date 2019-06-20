package com.yc.user.flter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@Component
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
//        String uid=request.getParameter("uid");
//        if(uid ==null){
//            System.out.println("preHandle用户未登录！！");
//            response.getWriter().write("-1");
//            return false;
//        }else{
//            System.out.println("user：通过");
//            String nid=request.getParameter("nid");
//            String vip=request.getParameter("vip");
//            System.out.println("vip等级"+vip+"  uid:"+uid+" 访问了"+nid);
//            return true;
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
