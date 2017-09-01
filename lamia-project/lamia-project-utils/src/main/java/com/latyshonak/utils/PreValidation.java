package com.latyshonak.utils;



import com.latyshonak.dao.hibernate.HibernateUtil;
import com.latyshonak.entity.Users;
import org.hibernate.Session;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PreValidation {

	public static boolean checkLogin(String check) {
		Pattern p = Pattern.compile("^[a-zA-Z][a-zA-Z0-9-_\\.]{5,20}$");
		Matcher m = p.matcher(check);
		if (m.matches()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean checkPassword(String check) {
		Pattern p = Pattern.compile("(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$");
		Matcher m = p.matcher(check);
		if (m.matches()) {
			return true;
		}
		else {
			return false;
		}
	}

	public static boolean checkRepeatPassword(String check, String secondCheck) {

		if (check.equals(secondCheck)) {
			return true;
		}
		else {
			return false;
		}
	}

	public static boolean checkAutorizationLogin(String login, String password) {
		Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
		List<Users> list = (hibernateSession.createQuery("from Users where login='" + login + "'").list());
		if (!list.isEmpty()) {
			if (password.equals(list.get(0).getPassword())) {
				return true;
			}
			return false;
		}
		else {
			return false;
		}
		}

}
