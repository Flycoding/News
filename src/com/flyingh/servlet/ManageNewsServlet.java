package com.flyingh.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ManageNewsServlet")
public class ManageNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String viewCount = request.getParameter("viewCount");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(title + "--->" + viewCount);
		System.out.println(title + "--->" + viewCount);
	}

}
