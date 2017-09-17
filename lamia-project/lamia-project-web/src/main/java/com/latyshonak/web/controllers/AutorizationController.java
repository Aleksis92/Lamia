package com.latyshonak.web.controllers;



import com.latyshonak.entity.Users;
import com.latyshonak.service.UsersService;
import com.latyshonak.service.beans.UsersBean;
import com.latyshonak.utils.PreValidation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class AutorizationController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/Autorization", method = RequestMethod.POST)
    public String AutorizationPost(HttpSession session, HttpServletRequest request, @ModelAttribute("UserFromJspAutorization") UsersBean userFromJSP) {
        if(PreValidation.checkAutorizationLogin(userFromJSP, usersService.getUserByUserName(userFromJSP.getLogin()))) {
         session.setAttribute("Autorization", "true");
         session.setAttribute("Login", userFromJSP.getLogin());
        }
        else {
            session.setAttribute("Autorization", "false");
        }
        return "redirect:Autorization";
    }

    @RequestMapping(value = "/Autorization", method = RequestMethod.GET)
    public ModelAndView AutorizationGet(HttpSession session) {
        if(usersService.getUserByUserName(session.getAttribute("Login").toString()).getRole()==1) {
            session.setAttribute("Role", 1);
            return new ModelAndView("redirect:ModeratorsRoom");
        }
        else {
            session.setAttribute("Role", 0);
            return new ModelAndView("redirect:Index");
        }
    }

}
