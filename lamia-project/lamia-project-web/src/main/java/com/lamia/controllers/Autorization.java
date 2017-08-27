package com.lamia.controllers;

import com.lamia.classes.Validation;
import com.lamia.entity.Users;
import com.lamia.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class Autorization {

    @RequestMapping(value = "/Autorization", method = RequestMethod.POST)
    public void AutorizationPost(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        if(Validation.checkAutorizationLogin(request.getParameter("autorization-login"), request.getParameter("autorization-password"))){
         session.setAttribute("Autorization", "true");
         session.setAttribute("Login", request.getParameter("autorization-login"));
        }
        else {
            session.setAttribute("Autorization", "false");
        }
        try {
            response.sendRedirect("Autorization");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/Autorization", method = RequestMethod.GET)
    public String AutorizationGet(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
        List<Users> list = (hibernateSession.createQuery("from Users where login='" + session.getAttribute("Login") + "'").list());
        if(list.get(0).getRole() == 1 ) {
            session.setAttribute("Role", 1);
            return "moderatorsRoom";
        }
        else {
            session.setAttribute("Role", 0);
            return "index";
        }
    }

}
