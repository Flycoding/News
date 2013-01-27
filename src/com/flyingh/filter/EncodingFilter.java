package com.flyingh.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class EncodingFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		if ("GET".equals(req.getMethod())) {
			req = new EncodingHttpServletRequestWrapper(req);
		} else if ("POST".equals(req.getMethod())) {
			req.setCharacterEncoding("utf-8");
		}
		chain.doFilter(req, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
