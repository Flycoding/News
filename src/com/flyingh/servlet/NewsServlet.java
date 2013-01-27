package com.flyingh.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyingh.vo.News;

@WebServlet("/NewsServlet")
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if ("json".equals(request.getParameter("format"))) {
			request.setAttribute("json", getJsonNews());
			request.getRequestDispatcher("/WEB-INF/jsp/jsonNews.jsp").forward(request, response);
		} else {
			request.setAttribute("news", getLatestNews());
			request.getRequestDispatcher("/WEB-INF/jsp/news.jsp").forward(request, response);
		}
	}

	private String getJsonNews() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (News item : getLatestNews()) {
			sb.append("{");
			sb.append("id:").append(item.getId()).append(",").append("title:").append("\"").append(item.getTitle()).append("\",")
					.append("viewCount:").append(item.getViewCount());
			sb.append("},");
		}
		return sb.deleteCharAt(sb.length() - 1).append("]").toString();
	}

	private List<News> getLatestNews() {
		Random rnd = new Random();
		List<News> news = new ArrayList<News>();
		for (int i = 1; i < 11; i++) {
			news.add(new News(i, "news" + i, rnd.nextInt(1000)));
		}
		return news;
	}

}
