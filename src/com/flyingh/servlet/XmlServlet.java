package com.flyingh.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/XmlServlet")
public class XmlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InputStream is = request.getInputStream();
		byte[] bytes = getBytes(is);
		System.out.println(new String(bytes));
	}

	private byte[] getBytes(InputStream is) throws IOException {
		byte[] buf = new byte[1024];
		int len = -1;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		while ((len = is.read(buf)) != -1) {
			os.write(buf, 0, len);
		}
		return os.toByteArray();
	}

}
