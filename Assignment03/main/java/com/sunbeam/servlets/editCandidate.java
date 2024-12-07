package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;
@WebServlet("/editcand")
public class editCandidate extends HttpServlet{
	@Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext app=this.getServletContext();
        String color=app.getInitParameter("bg.color");
        String appTitle = app.getInitParameter("app.title");
		
		String sId=req.getParameter("id");
		  int id=Integer.parseInt(sId);
		  PrintWriter out=resp.getWriter();
		  out.println("<html>");
	      out.println("<head>");
	      out.println("<title>Edit Candidate</title>");
	      out.println("<style>");
	      out.printf("body { font-family: Arial, sans-serif; background-color: %s; margin: 0; padding: 20px; }",color);
	      out.println(".container { width: 100%; max-width: 450px; margin: 50px auto; background: #fff; border-radius: 10px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); padding: 20px;}");
	      out.println("h2 { color: #333; margin-bottom: 20px; }");
	      out.println("form { margin-top: 20px; }");
	      out.println("input{padding: 10px; margin-bottom: 15px; border: 1px solid #ced4da; border-radius: 5px; font-size: 14px;}");
	      out.println("input[type='submit'] { padding: 10px 20px; background-color: #007BFF; color: #fff; border: none; border-radius: 5px; cursor: pointer; }");
	      out.println("input[type='submit']:hover { background-color: #0056b3; }");
	      out.println("</style>");
	      out.println("</head>");
	      out.println("<body>");
	      out.printf("<h1>%s</h1>", appTitle);
          out.printf("<hr>");
	      out.println("<div class='container'>");
	      out.println("<h2>Edit Candidate</h2>");
		  try(CandidateDao canDao=new CandidateDaoImpl())
		  {
			  Candidate c=canDao.findById(id);
			  if(c!=null)
			  {
				  out.printf("<form method='post' action='editcand'>");
			      out.printf("<input type='hidden' name='id' value='%d'><br/><br/>",c.getId());
			      out.printf("<input type='text' name='name' value='%s'><br/><br/>",c.getName());
			      out.printf("<input type='text' name='party' value='%s'><br/><br/>",c.getParty());
			      out.printf("<input type='number' name='votes' value='%d' readonly><br/><br/>",c.getVotes());
			      out.println("<br/><input type='submit' value='Vote'/>");
			      out.println("</form>");
			  }
		  } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  out.println("</div>");
	      out.println("</body>");
	      out.println("</html>");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid=req.getParameter("id");
        String name=req.getParameter("name");
        String party=req.getParameter("party");
        String svotes=req.getParameter("votes");
        int id=Integer.parseInt(sid);
        int votes=Integer.parseInt(svotes);
        try(CandidateDao canDao=new CandidateDaoImpl())
        {
        	Candidate c=new Candidate(id,name,party,votes);
        	int count=canDao.update(c);
        	String message = "Candidates updated: " + count;
			req.setAttribute("msg", message);
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException(e);
		}
        RequestDispatcher rd=req.getRequestDispatcher("result");
        rd.forward(req, resp);
        
    }
}
