package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		
		Cookie c1 = new Cookie("uname", "");
		c1.setMaxAge(-1);
		resp.addCookie(c1);
		Cookie c2 = new Cookie("role", "");
		c2.setMaxAge(-1);
		resp.addCookie(c2);
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Logout</title>");
		out.println("<style>\r\n"
				+ "\r\n"
				+ "*{\r\n"
				+ "	margin: 0;\r\n"
				+ "	padding: 0;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "body\r\n"
				+ "{\r\n"
				+ "	height: 100vh;\r\n"
				+ "	width: 100vw;\r\n"
				+ "	background: #fff;\r\n"
				+ "	color: #000;\r\n"
				+ "	display: flex;\r\n"
				+ "	justify-content: center;\r\n"
				+ "	align-items: center;\r\n"
				+ "	flex-direction: column;\r\n"
				+ "	font-family: Arial;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2 style='font-size:30px'>Thank you</h2>");
		out.println("<p style='margin:2vh 0; font-size:16px; '>Your vote matters</p>");
		out.println("<p style='margin:2vh 0'><a href='index.html' style='background-color:#6666ff; color:#fff; font-size: 16px; padding: 1vh 2vw; text-decoration: none; underline:none; border-radius: 20px'>Login Again</a></p>");
		out.println("</body>");
		out.println("</html>");	
	}
}

