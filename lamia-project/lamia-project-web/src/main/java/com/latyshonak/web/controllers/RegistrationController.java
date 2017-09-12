package com.latyshonak.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import com.latyshonak.entity.Users;
import com.latyshonak.service.UsersService;
import com.latyshonak.utils.PreValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class RegistrationController {

	@Autowired
	private UsersService usersService;

	@RequestMapping(value = "/Registration", method = RequestMethod.POST)
	public String RegistrationPost(HttpServletRequest request, HttpSession session) {
		if (PreValidation.checkLogin(request.getParameter("registration-login"))) {
			if (usersService.getUserByUserName(request.getParameter("registration-login"))==null) {
				session.setAttribute("validationLogin", "true");
			}
			else {
				session.setAttribute("validationLogin", "false2");
			}
		}
		else {
			session.setAttribute("validationLogin", "false1");
		}

		if (PreValidation.checkPassword(request.getParameter("registration-password"))) {
			session.setAttribute("validationPassword", "true");
		}
		else {
			session.setAttribute("validationPassword", "false");
		}

		if (PreValidation.checkRepeatPassword(request.getParameter("registration-password"), request.getParameter("registration-second-password"))) {
			session.setAttribute("validationRepeatPassword", "true");
		}
		else {
			session.setAttribute("validationRepeatPassword", "false");
		}

		if (session.getAttribute("validationLogin").equals("true") && session.getAttribute("validationPassword").equals("true") && session.getAttribute("validationRepeatPassword").equals("true")) {

			usersService.insertUser(request.getParameter("registration-login"), request.getParameter("registration-password"),
					request.getParameter("registration-email"));
		}
		return "redirect:Registration";
	}


	@RequestMapping(value = "/Registration", method = RequestMethod.GET)
	public String RegistrationGet() {
		return "index";
	}

}