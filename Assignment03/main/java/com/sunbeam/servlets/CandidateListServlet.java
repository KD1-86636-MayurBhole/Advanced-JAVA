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
import javax.servlet.http.HttpSession;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;
import com.sunbeam.entities.User;
@WebServlet("/candlist")
public class CandidateListServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("call to doPost()");
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	ServletContext app=this.getServletContext();
        String color=app.getInitParameter("bg.color");
        String appTitle = app.getInitParameter("app.title");
        
        HttpSession session = req.getSession(false);
        if(session == null) {
            resp.sendError(440);
            return;
            }
        User user = (User) session.getAttribute("curuser");
    	
    	List<Candidate> list = new ArrayList<>();
        try (CandidateDao canDao = new CandidateDaoImpl()) {
            list = canDao.findAll();
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Candidates List</title>");
        out.println("<style>");
        out.printf("body { font-family: Arial, sans-serif; background-color: %s; margin: 0; padding: 20px; }",color);
        out.println(".container { max-width: 600px; margin: 20px auto; background: #fff; border-radius: 10px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); padding: 20px; }");
        out.println("h2 { color: #333; margin-bottom: 20px; }");
        out.println("form { margin-top: 20px; }");
        out.println("input[type='radio'] { margin-right: 10px; }");
        out.println("input[type='submit'] { padding: 10px 20px; background-color: #007BFF; color: #fff; border: none; border-radius: 5px; cursor: pointer; }");
        out.println("input[type='submit']:hover { background-color: #0056b3; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.printf("<h1>%s</h1>", appTitle);
        out.printf("<hr>");
        ServletContext ctx=this.getServletContext();
        String ann=(String)ctx.getAttribute("announcement");
        out.printf("<p style='color:red;'>%s</p>",ann);
        out.println("<div class='container'>");

        Cookie[] cookies = req.getCookies();
        String userName = "", role = "";
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("uname".equals(cookie.getName()))
                    userName = cookie.getValue();
                if ("role".equals(cookie.getName()))
                    role = cookie.getValue();
            }
        }

        out.printf("<p>Hello, <strong>%s</strong> (<em>%s</em>)</p><hr/>\n", user.getFirstName(), user.getRole());
        out.println("<h2>Candidate List</h2>");
        out.println("<form method='post' action='vote'>");

        for (Candidate c : list) {
            out.printf("<div><input type='radio' name='candidate' value='%d'/> %s (%s)</div>\n",
                    c.getId(), c.getName(), c.getParty());
        }

        out.println("<br/><input type='submit' value='Vote'/>");
        out.println("</form>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}
