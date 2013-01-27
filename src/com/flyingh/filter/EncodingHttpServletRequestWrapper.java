package com.flyingh.filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncodingHttpServletRequestWrapper extends HttpServletRequestWrapper {

	public EncodingHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {
		String parameter = super.getParameter(name);
		try {
			if (isNotEmpty(parameter)) {
				return new String(parameter.getBytes("iso-8859-1"), "utf-8");
			}
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		return parameter;
	}

	private boolean isNotEmpty(String parameter) {
		return parameter != null && !"".equals(parameter.trim());
	}
}
