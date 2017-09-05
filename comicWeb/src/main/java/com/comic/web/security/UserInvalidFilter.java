package com.comic.web.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.comic.web.bean.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;


public class UserInvalidFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		if (null == user) {
			response.getWriter().write("<script>window.parent.location.reload();</script>");
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

}
