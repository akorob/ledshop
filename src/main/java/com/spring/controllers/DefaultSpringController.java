package com.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Andrey on 30.12.2014.
 */
@Controller
public class DefaultSpringController {

   @RequestMapping("*")
    public String forwardRequest(final HttpServletRequest request) {
       // return "forward:/legacy" + request.getRequestURI();
        return "/resources/start.html";
    }

}
