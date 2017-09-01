package com.latyshonak.web.tags;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class RegistrationTag extends BodyTagSupport{

	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		HttpSession session = pageContext.getSession();
		try {
			if (session.getAttribute("validationLogin") != null && session.getAttribute("validationLogin").equals("true") &&
					session.getAttribute("validationPassword") != null && session.getAttribute("validationPassword").equals("true") &&
					session.getAttribute("validationRepeatPassword") != null && session.getAttribute("validationRepeatPassword").equals("true")
					) {
				out.print(
						"<label id=\"label-registration-login1\" class=\"autorization-label content-registration\">Вы успешно зарегистрированы</label>");
			} else {
				if (session.getAttribute("validationLogin") != null
						&& session.getAttribute("validationLogin").equals("false1")) {
					out.print(
							"<label id=\"label-registration-login2\" class=\"autorization-label content-registration\">Логин должен содержать 5-20 символов,буквы и цифры, первый символ - буква</label>");
				}
				if (session.getAttribute("validationLogin") != null
						&& session.getAttribute("validationLogin").equals("false2")) {
					out.print(
							"<label id=\"label-registration-login2\" class=\"autorization-label content-registration\">Указанный логин уже занят</label>");
				}
			}
			session.setAttribute("validationLogin", "ignore");

			if (session.getAttribute("validationPassword") != null && session.getAttribute("validationPassword").equals("false")) {
				out.print(
						"<label id=\"label-registration-Password1\" class=\"autorization-label content-registration\"> Ошибочный формат пароля </label>");
			}
			session.setAttribute("validationPassword", "ignore");

			if (session.getAttribute("validationRepeatPassword") != null && session.getAttribute("validationRepeatPassword").equals("false")) {
				out.print(
						"<label id=\"label-registration-Password2\" class=\"autorization-label content-registration\"> Пароли не совпадают </label>");
			}
			session.setAttribute("validationRepeatPassword", "ignore");

		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
}
