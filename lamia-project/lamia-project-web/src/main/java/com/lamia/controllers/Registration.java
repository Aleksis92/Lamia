package com.lamia.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lamia.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.context.request.WebRequest;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lamia.classes.Validation;
import com.lamia.dao.DaoUsers;
import com.lamia.entity.Users;

@Controller
public class Registration {

	@RequestMapping(value = "/Registration", method = RequestMethod.POST)
	public void RegistrationPost(HttpServletRequest request, HttpSession session, HttpServletResponse response) {
//dsfsdfsd
		if (Validation.checkLogin(request.getParameter("registration-login"))) {
			Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
			if (hibernateSession.createQuery("from Users where login = '" + request.getParameter("registration-login") + "'").list().isEmpty()) {
				session.setAttribute("validationLogin", "true");
			}
			else {
				session.setAttribute("validationLogin", "false2");
			}
            hibernateSession.close();
		}
		else {
			session.setAttribute("validationLogin", "false1");
		}

		if (Validation.checkPassword(request.getParameter("registration-password"))) {
			session.setAttribute("validationPassword", "true");
		}
		else {
			session.setAttribute("validationPassword", "false");
		}

		if (Validation.checkRepeatPassword(request.getParameter("registration-password"), request.getParameter("registration-second-password"))) {
			session.setAttribute("validationRepeatPassword", "true");
		}
		else {
			session.setAttribute("validationRepeatPassword", "false");
		}

		if (session.getAttribute("validationLogin").equals("true") && session.getAttribute("validationPassword").equals("true") && session.getAttribute("validationRepeatPassword").equals("true")) {
			DaoUsers du = new DaoUsers();
			du.insert(new Users(request.getParameter("registration-login"), request.getParameter("registration-password"),
					request.getParameter("registration-email")));
		}
		try {
			response.sendRedirect("Registration");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	@RequestMapping(value = "/Registration", method = RequestMethod.GET)
	public String RegistrationGet(Model model, HttpServletRequest request, HttpSession session) {
	return "index";
	}

}
