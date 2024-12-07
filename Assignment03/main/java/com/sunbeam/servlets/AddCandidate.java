package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletContext;
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
@WebServlet("/addcandidate")
public class AddCandidate extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	ServletContext app=this.getServletContext();
        String color=app.getInitParameter("bg.color");
        String appTitle = app.getInitParameter("app.title");
        
    	String name = req.getParameter("name");
        String party = req.getParameter("party");
        String votes = req.getParameter("votes");
        int vote = Integer.parseInt(votes);

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        try (CandidateDao canDao = new CandidateDaoImpl()) {
            Candidate c = new Candidate(0, name, party, vote);
            int result = canDao.save(c);

            PrintWriter out = resp.getWriter();
            out.printf("<html>");
            out.printf("<head>");
            out.printf("<title>Voting Application</title>");
            out.printf("<style>");
            out.printf("body { font-family: Arial, sans-serif; background-color: %s; margin: 0; padding: 20px; }",color);
            out.printf(".container { max-width: 600px; margin: 50px auto; background: #fff; border-radius: 10px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); padding: 20px; }");
            out.printf("h2 { color: #333; }");
            out.printf("p { color: #555; }");
            out.printf("a { color: #007BFF; text-decoration: none; }");
            out.printf("a:hover { text-decoration: underline; }");
            out.printf("</style>");
            out.printf("</head>");
            out.printf("<body>");
            out.printf("<h1>%s</h1>", appTitle);
            out.printf("<hr>");
            out.printf("<div class='container'>");

            if (result == 0) {
                out.printf("<h2>Something went wrong</h2>");
                out.printf("<p>Please try again.</p>");
                out.printf("<a href='newcandidate.html'>Register a new candidate</a>");
            } else {
                out.printf("<h2>Candidate %s</h2>", name);
                out.printf("<p>Added successfully!</p>");
                out.printf("<a href='candlist'>View candidate list</a>");
            }

            out.printf("</div>");
            out.printf("</body>");
            out.printf("</html>");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}
