package com.yejf.web.controller;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainControllerInterceptor implements HandlerInterceptor {

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (request.getRequestURI().endsWith("hello")){
            response.getWriter().print(" world");
        }
    }

}
