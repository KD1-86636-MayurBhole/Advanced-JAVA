package com.sunbeam.servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.Candidate;
import com.sunbeam.entities.User;

@WebServlet("/resgiterCandidate")
public class RegisterCandidateServlet extends HttpServlet{
	
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
		
		String name = req.getParameter("name");
		String party = req.getParameter("party");
		String votes = req.getParameter("votes");
		int fVote = Integer.parseInt(votes);
		
		Candidate cd = new Candidate(name, party, fVote); 
		
		try(CandidateDao cdDao = new CandidateDaoImpl())
		{
			cdDao.save(cd);
			resp.sendRedirect("result");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
	
	
	
	
	
	
	
	
}
