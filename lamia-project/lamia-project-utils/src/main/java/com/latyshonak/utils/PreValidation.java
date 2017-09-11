package com.latyshonak.utils;




import com.latyshonak.entity.Users;
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

	public static boolean checkAutorizationLogin(Users userFromForm, Users userFromDatabase) {
		if (userFromDatabase.getLogin().equals(userFromForm.getLogin()) &&
				userFromDatabase.getPassword().equals(userFromForm.getPassword())) {
			return true;
		} else {
			return false;
		}
	}

}
