package com.sunbeam.servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String firstName = req.getParameter("fName");
		String lastName = req.getParameter("lName");
		String email = req.getParameter("email");
		String password = req.getParameter("passwd");
		String dob = req.getParameter("dob");
		int status = 0;
		String role = "voter";
		
		Date dt = Date.valueOf(dob);
		
		User usr = new User(firstName, lastName, email, password, dt, status, role);
		
		try(UserDao usrDao = new UserDaoImpl())
		{
			usrDao.save(usr);
			resp.sendRedirect("index.html");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
