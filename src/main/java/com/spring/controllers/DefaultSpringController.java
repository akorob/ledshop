package com.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Andrey on 30.12.2014.
 */
@Controller
public class DefaultSpringController extends HttpServlet {
    //Handle all unmapped urls
/*   @RequestMapping("*")

    public String forwardRequest(final HttpServletRequest request) {
System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
       return "/resources/start.html";
    }*/

/*@RequestMapping("*")
    public String forwardRequest(final HttpServletRequest request, HttpServletResponse response) {
        System.out.println("##############################################");
        return "/resources/start.html";
    }*/

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) {
        System.out.println("Poooooooooooooooooooost");
    }

    public void doGet(HttpServletRequest request,
                       HttpServletResponse response)throws ServletException, IOException {
        System.out.println("Geeeeeeeeeeeeeeeeeeeeeeeet") ;

       RequestDispatcher view = request.getRequestDispatcher("/resources/start.html");
     //  view.forward(request, response);
       // System.out.println(request.getContextPath()) ;
       // response.sendRedirect(request.getContextPath() + "/resources/start.html");

    }


}
