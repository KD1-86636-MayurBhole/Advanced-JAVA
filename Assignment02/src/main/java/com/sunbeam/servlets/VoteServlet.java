package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;

@WebServlet("/vote")
public class VoteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String candId = req.getParameter("candidate"); 
		int id = Integer.parseInt(candId);
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Result</title>");
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
		
		Cookie[] arr = req.getCookies();
		String userName = "", role = "";
		if(arr != null) {
			for (Cookie c : arr) {
				if(c.getName().equals("uname"))
					userName = c.getValue();
				if(c.getName().equals("role"))
					role = c.getValue();
			}
		}
		
		out.printf("Hello, %s (%s)<hr/>\n", userName, role);
		out.println("<h2 style='font-size:30px'>Voting Status</h2>");

		try(CandidateDao candDao = new CandidateDaoImpl()) {
			int count = candDao.incrVote(id);
			int statusCnt = candDao.changeStatus(id);
			if(count == 1 && statusCnt==1)
				out.println("<p style='margin:2vh 0; font-size:16px; '>Thanks for Voting...!</p>");
			else
				out.println("<h4 style='margin:2vh 0; font-size:16px;color:red '>Your voting failed :(</h4>");
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		out.println("<p style='margin:2vh 0'><a href='logout' style='background-color:#ff4d4d; color:#fff; font-size: 16px; padding: 1vh 2vw; text-decoration: none; underline:none; border-radius: 20px'>Sign Out</a></p>");
		out.println("</body>");
		out.println("</html>");
	}
}