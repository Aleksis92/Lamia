package com.latyshonak.web.controllers;

import com.latyshonak.entity.Users;
import com.latyshonak.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class ModeratorsRoomController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/ModeratorsRoom")
    public ModelAndView moderatorsRoomReturn(HttpSession session) {
        if (session.isNew()) {
            session.setAttribute("Autorization", "ignored");
            session.setAttribute("Login", "ignored");
            session.setAttribute("Role", "ignored");
            return new ModelAndView("redirect:Index");
        }
           else{
                if (session.getAttribute("Autorization").toString().equals("true") && session.getAttribute("Role").toString().equals("1") && usersService.getUserByUserName(session.getAttribute("Login").toString()).getRole() == 1) {
                    return new ModelAndView("moderatorsRoom");
                }
                else {
                    return new ModelAndView("redirect:Index");
                }
            }
    }



}
