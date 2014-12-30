package com.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Andrey on 30.12.2014.
 */
@Controller
public class DefaultSpringController {
    //Handle all unmapped urls
   @RequestMapping("*")
    public String forwardRequest(final HttpServletRequest request) {
        return "/resources/start.html";
    }

}
