package com.latyshonak.web.controllers;



import com.latyshonak.entity.Users;
import com.latyshonak.service.UsersService;
import com.latyshonak.utils.PreValidation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class AutorizationController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/Autorization", method = RequestMethod.POST)
    public String AutorizationPost(HttpSession session, HttpServletRequest request) {
        if(PreValidation.checkAutorizationLogin(new Users(request.getParameter("autorization-login"), request.getParameter("autorization-password")),
           usersService.getUserByUserName(request.getParameter("autorization-login")))){
         session.setAttribute("Autorization", "true");
         session.setAttribute("Login", request.getParameter("autorization-login"));
        }
        else {
            session.setAttribute("Autorization", "false");
        }
        return "redirect:Autorization";
    }

    @RequestMapping(value = "/Autorization", method = RequestMethod.GET)
    public String AutorizationGet(HttpSession session) {

        if(usersService.getUserByUserName(session.getAttribute("Login").toString()).getRole()==1) {
            session.setAttribute("Role", 1);
            return "redirect:ModeratorsRoom";
        }
        else {
            session.setAttribute("Role", 0);
            return "redirect:index";
        }
    }

}
