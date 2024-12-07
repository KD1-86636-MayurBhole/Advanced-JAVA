package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
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
        HttpSession session=req.getSession();
        session.invalidate();

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        
        ServletContext app=this.getServletContext();
        String color=app.getInitParameter("bg.color");
        String appTitle = app.getInitParameter("app.title");

        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Logout</title>");
        out.println("<style>");
        out.printf("body { font-family: Arial, sans-serif; background-color: %s; margin: 0; padding: 20px; }",color);
        out.println(".container { max-width: 400px; margin: 50px auto; background: #fff; border-radius: 10px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); padding: 20px; text-align: center; }");
        out.println("h2 { color: #28a745; }");
        out.println("p { color: #555; margin: 10px 0; }");
        out.println("a { color: #007BFF; text-decoration: none; font-weight: bold; }");
        out.println("a:hover { text-decoration: underline; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.printf("<h1>%s</h1>", appTitle);
        out.printf("<hr>");
        out.println("<div class='container'>");
        out.println("<h2>Thank You!</h2>");
        out.println("<p>You have been successfully logged out.</p>");
        out.println("<p>See you after 5 years.</p>");
        out.println("<p><a href='index.html'>Login Again</a></p>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}

