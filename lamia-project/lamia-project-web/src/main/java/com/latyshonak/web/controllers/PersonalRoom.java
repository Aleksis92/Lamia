package com.latyshonak.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class PersonalRoom {

    @RequestMapping(value = "/PersonalRoom", method = RequestMethod.POST)
    public void AutorizationPost(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        session.setAttribute("Autorization", "false");
        try {
            response.sendRedirect("PersonalRoom");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/PersonalRoom", method = RequestMethod.GET)
    public String AutorizationGet(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        return "index";
    }

}
