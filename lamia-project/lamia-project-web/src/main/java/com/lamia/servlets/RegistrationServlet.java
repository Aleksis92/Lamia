package com.lamia.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lamia.dao.DaoUsers;
import com.lamia.entity.Users;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	public void init() throws ServletException {
		
	}
      
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("validationLogin").equals("true")) {
		DaoUsers du = new DaoUsers();
		du.insert(new Users(request.getParameter("registration-login"), request.getParameter("password-login"),request.getParameter("registration-email") ));
		session.setAttribute("validationLogin", "true");
		response.sendRedirect("index.jsp"); 
		}
		else {
			response.sendRedirect("index.jsp");
		}
	}

	@Override
	public void destroy() {

	}
 
}