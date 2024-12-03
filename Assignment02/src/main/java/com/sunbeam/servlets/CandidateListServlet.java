package com.sunbeam.servlets;

import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

@WebServlet("/candlist")
public class CandidateListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Candidate> list = new ArrayList<>();

		try(CandidateDao candDao = new CandidateDaoImpl()) {
			list = candDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Candidate List</title>");
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
				+ "form\r\n"
				+ "{\r\n"
				+ "	padding: 3vh 6vw;\r\n"
				+ "	border-radius: 20px;\r\n"
				+ "	display: flex;\r\n"
				+ "	background-color: #dbdbdb;\r\n"
				+ "	justify-content: center;\r\n"
				+ "	margin: 3.5vh 0 0 0;\r\n"
				+ "	/*align-items: center;*/\r\n"
				+ "	flex-direction: column;\r\n"
				+ "	text-align: left;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "form input \r\n"
				+ "{\r\n"
				+ "	padding: 2vh 4vw;\r\n"
				+ "	border:none;\r\n"
				+ "	outline: none;\r\n"
				+ " width: 15vw;\r\n"
				+ "	background-color: #dbdbdb;\r\n"
				+ "	border-radius: 10px;\r\n"
				+ "	font-size: 15PX;\r\n"
				+ "	font-weight: 600;\r\n"
				+ "	display: flex;\r\n"
				+ "	gap: 3vw;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "	\r\n"
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
		out.printf("<h3 style='font-size:25px;'>Hello, %s %s</h3><hr/>\n", userName, role);
		
		out.println("<h2 style='font-size:25px;margin-top: 2vh;'>Candidate List</h2>");
		out.println("<form method='post' action='vote'>");
		for(Candidate c : list) {
			out.printf("<input type='radio' name='candidate' value='%d'/> %s <br/>\n", 
					c.getId(), c.getName());
		}
		out.println("<br/><input type='submit' value='Vote' style=\"background-color:#6666ff; color: #fff; font-size: 20px; padding: 1vh 2vw\"/>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
	
	
	
	
	
	
	
	
}
