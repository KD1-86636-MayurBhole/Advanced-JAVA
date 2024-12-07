package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;
@WebServlet("/result")
public class ResultServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("call to doPost()");
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Candidate> list = new ArrayList<>();
        try (CandidateDao canDao = new CandidateDaoImpl()) {
            list = canDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        ServletContext app=this.getServletContext();
        String color=app.getInitParameter("bg.color");
        String appTitle = app.getInitParameter("app.title");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Result</title>");
        out.println("<style>");
        out.printf("body { font-family: Arial, sans-serif; background-color: %s; margin: 20px; }",color);
        out.println("table { width: 80%; border-collapse: collapse; margin: 20px auto; background-color: #fff; }");
        out.println("th, td { padding: 10px; text-align: left; border: 1px solid #ddd; }");
        out.println("th { background-color: #007bff; color: white; }");
        out.println("tr:nth-child(even) { background-color: #f2f2f2; }");
        out.println("a { text-decoration: none; color: #007bff; }");
        out.println("a:hover { text-decoration: underline; }");
        out.println("h2 { text-align: center; color: #333; }");
        out.println("hr { margin: 20px auto; width: 80%; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.printf("<h1>%s</h1>", appTitle);
        out.printf("<hr>");
        ServletContext ctx=this.getServletContext();
        String ann=(String)ctx.getAttribute("announcement");
        out.printf("<h1 style='color:red;'>%s<p>",ann);
        String message = (String) req.getAttribute("msg");
        if(message != null)
           out.println("<p>" + message + "</p>");


        out.println("<h2>Voting Result</h2>");
        out.println("<table>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>Id</th>");
        out.println("<th>Name</th>");
        out.println("<th>Party</th>");
        out.println("<th>Votes</th>");
        out.println("<th>Action</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");
        for (Candidate c : list) {
            out.println("<tr>");
            out.printf("<td>%d</td>", c.getId());
            out.printf("<td>%s</td>", c.getName());
            out.printf("<td>%s</td>", c.getParty());
            out.printf("<td>%d</td>", c.getVotes());
            out.printf("<td>");
            out.printf("<a href='editcand?id=%d'><img src='images/edit.png' alt='Edit' width='24' height='24'/></a>\n", c.getId());
            out.printf("<a href='deletecand?id=%d'><img src='images/delete.png' alt='Delete' width='24' heigth='24'/></a>\n",c.getId());
            out.println("</tr>");
        }
        out.println("</tbody>");
        out.println("</table>");

        out.println("<p style='text-align: center;'><a href='newcandidate.html'>Add Candidate</a></p>");
        out.println("<p style='text-align: center;'><a href='announcement.html'>Make Announcement</a></p>");
        out.println("<p style='text-align: center;'><a href='logout'>Sign Out</a></p>");
        out.println("</body>");
        out.println("</html>");
    }
}
