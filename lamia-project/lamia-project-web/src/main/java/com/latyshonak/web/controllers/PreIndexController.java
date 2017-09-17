package com.latyshonak.web.controllers;

import com.latyshonak.entity.Users;
import com.latyshonak.service.beans.UsersBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class PreIndexController {

    @ModelAttribute("UserFromJspRegistration")
    private UsersBean getRegistrationUser() {
        return  new UsersBean();
    }

    @ModelAttribute("UserFromJspAutorization")
    private UsersBean getAutorizationUser() {
        return  new UsersBean();
    }

    @RequestMapping(value = "/")
    public ModelAndView indexReturn (HttpSession session) {
        if (session.isNew()) {
            session.setAttribute("Autorization", "ignored");
            session.setAttribute("Login", "ignored");
            session.setAttribute("Role", "ignored");}
        return new ModelAndView("index");
    }
}
