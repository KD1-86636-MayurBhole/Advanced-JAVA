package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

@WebServlet("/vote")
public class VoteServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String candId = req.getParameter("candidate");
        int id = Integer.parseInt(candId);
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        
        HttpSession session = req.getSession(false);
        if(session == null) {
            resp.sendError(440);
            return;
            }
        
        ServletContext app=this.getServletContext();
        String color=app.getInitParameter("bg.color");
        String appTitle = app.getInitParameter("app.title");
        
        User user = (User) session.getAttribute("curuser");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Vote</title>");
        out.println("<style>");
        out.printf("body { font-family: Arial, sans-serif; background-color: %s; margin: 0; padding: 0; }",color);
        out.println(".container { width: 80%; margin: 0 auto; padding: 20px; background-color: #fff; border-radius: 8px; box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); }");
        out.println("h2 { color: #333; font-size: 24px; }");
        out.println("h4 { color: green; font-size: 20px; }");
        out.println("a { text-decoration: none; color: #0066cc; font-weight: bold; }");
        out.println("a:hover { text-decoration: underline; }");
        out.println("hr { margin: 20px 0; border: 0; border-top: 1px solid #ccc; }");
        out.println(".message { font-size: 18px; margin-bottom: 20px; }");
        out.println(".footer { text-align: center; padding: 10px; background-color: #f4f4f9; border-top: 1px solid #ddd; margin-top: 20px; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.printf("<h1>%s</h1>", appTitle);
        out.printf("<hr>");
        out.println("<div class='container'>");

        out.println("<h2>Voting Status</h2>");
        
        if(user.getStatus()==0)
        {
        	System.out.println(user);
        	try (CandidateDao candDao = new CandidateDaoImpl()) {
                int count = candDao.incrVote(id);
                if (count != 0) {
                    out.println("<h4>You have successfully casted your vote.</h4>");
                    user.setStatus(1);
                    try(UserDao uDao=new UserDaoImpl())
                    {
                    	int ncount=uDao.update(user);
                    	if(ncount!=0)
                    		out.println("<h4>You are marked as voted.</h4>");
                    }
                } else {
                    out.println("<h4>Your voting failed. Please try again.</h4>");
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new ServletException(e);
            }
        }
        else {
        	out.println("<h4>You have already voted.</h4>");
        }

    	out.println("<p class='message'><a href='logout'>Sign Out</a></p>");
        
        out.println("</div>");
        
        out.println("<div class='footer'>");
        out.println("<p>&copy; Voting Application | All Rights Reserved</p>");
        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
}

