package com.spring.controllers.interceptors;

import org.slf4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Andrey on 31.12.2014.
 */
public class ExecuteTimeInterceptor extends HandlerInterceptorAdapter {


    //before the actual handler will be executed
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler)
            throws Exception {

      /*  long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);*/
        System.out.println("preeeeeeeeeeeeeeeeeeeeeeeeeeeee");

        return true;
    }

    //after the handler is executed
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response,
            Object handler, ModelAndView modelAndView)
            throws Exception {
        System.out.println("poooooooooooooooooooooooooooooost");
/*
        long startTime = (Long)request.getAttribute("startTime");

        long endTime = System.currentTimeMillis();

        long executeTime = endTime - startTime;

        //modified the exisitng modelAndView
        modelAndView.addObject("executeTime",executeTime);

        //log it
        if(logger.isDebugEnabled()){
            logger.debug("[" + handler + "] executeTime : " + executeTime + "ms");
        }*/


    }
}
