package com.spring.controllers;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Andrey on 31.12.2014.
 */
public class DefaultController extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
                                                 HttpServletResponse arg1) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("haaaaaaaaaaaaaaaaaaaaaaaaaaaaandleRequestInternal");

        ModelAndView mv = new ModelAndView();
        mv.setViewName("/resources/index.html");
        return mv;
    }
}
