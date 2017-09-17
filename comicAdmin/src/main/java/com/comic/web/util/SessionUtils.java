package com.comic.web.util;

import com.comic.web.bean.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {
    
	
	public static final String LOGIN_KEY = "loginUser";
	
	public static User getLoginUser(HttpServletRequest request){
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(LOGIN_KEY);
		return user;
	}
}
