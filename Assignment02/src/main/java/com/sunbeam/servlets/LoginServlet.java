package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("passwd");
		
		try(UserDao usrDao = new UserDaoImpl())
		{
			User usr = usrDao.findByEmail(email);
			
			if(usr != null &&  usr.getPassword().equals(password))
			{
				
				Cookie c1 = new Cookie("uname", usr.getFirstName());
				c1.setMaxAge(3600);
				resp.addCookie(c1);
				Cookie c2 = new Cookie("role", usr.getRole());
				c2.setMaxAge(3600);
				resp.addCookie(c2);
				
				if(usr.getRole().equals("admin")){
					resp.sendRedirect("result"); 
				} else { 
					;resp.sendRedirect("candlist"); 
				}
			}
			else
			{
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();
				
				out.println("<!DOCTYPE html>\r\n"
						+ "						<html>\r\n"
						+ "						<head>\r\n"
						+ "						<meta charset=\"ISO-8859-1\">\r\n"
						+ "						<title>Login</title>\r\n"
						+ "\r\n"
						+ "						<style>\r\n"
						+ "\r\n"
						+ "						*{\r\n"
						+ "							margin: 0;\r\n"
						+ "							padding: 0;\r\n"
						+ "						}\r\n"
						+ "\r\n"
						+ "						body\r\n"
						+ "						{\r\n"
						+ "							height: 100vh;\r\n"
						+ "							width: 100vw;\r\n"
						+ "							background: #fff;\r\n"
						+ "							color: #000;\r\n"
						+ "							display: flex;\r\n"
						+ "							justify-content: center;\r\n"
						+ "							align-items: center;\r\n"
						+ "							flex-direction: column;\r\n"
						+ "							font-family: Arial;\r\n"
						+ "						}\r\n"
						+ "\r\n"
						+ "						.errorDiv\r\n"
						+ "						{\r\n"
						+ "							height: 20vh;\r\n"
						+ "							width: 50vw;\r\n"
						+ "							border-radius: 20px;\r\n"
						+ "							font-size: 16px;\r\n"
						+ "							color: red;\r\n"
						+ "						}\r\n"
						+ "							\r\n"
						+ "						</style>\r\n"
						+ "\r\n"
						+ "						</head>\r\n"
						+ "						<body>\r\n"
						+ "							<div class=\"errorDiv\">\r\n"
						+ "								<h2>Wrong Credentials...!!! Please check your email or password</h2>\r\n"
						+ "							</div>\r\n"
						+ "\r\n"
						+ "						</body>\r\n"
						+ "						</html>");
			}
				
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e); // set here because it'll display error in console
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
