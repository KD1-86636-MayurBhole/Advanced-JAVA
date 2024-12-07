package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String date = req.getParameter("date");
        Date sqlDate = Date.valueOf(date); // Converts the string date to SQL Date format

        try (UserDao userDao = new UserDaoImpl()) {
            User user = new User(1, firstname, lastname, email, password, sqlDate, 0, "user");

            int result = userDao.save(user);

            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");
            PrintWriter out = resp.getWriter();
            
            ServletContext app=this.getServletContext();
            String color=app.getInitParameter("bg.color");
            String appTitle = app.getInitParameter("app.title");

            if (result == 0) {
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Voting Application</title>");
                out.printf("<style>body { font-family: Arial, sans-serif; background-color: %s; }</style>",color);
                out.println("</head>");
                out.println("<body>");
                out.printf("<h1>%s</h1>", appTitle);
                out.printf("<hr>");
                out.println("<h2 style='color: red;'>Something went wrong!</h2>");
                out.println("<p>Please try registering again.</p>");
                out.println("<a href='register.html' style='text-decoration: none; color: blue;'>Register Again</a>");
                out.println("</body>");
                out.println("</html>");
            } else {
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Voting Application</title>");
                out.println("<style>");
                out.printf("body { font-family: Arial, sans-serif; background-color: %s; text-align: center; }",color);
                out.println(".success { color: green; font-weight: bold; }");
                out.println("a { text-decoration: none; color: blue; }");
                out.println("a:hover { text-decoration: underline; }");
                out.println("</style>");
                out.println("</head>");
                out.println("<body>");
                out.printf("<h1>%s</h1>", appTitle);
                out.printf("<hr>");
                out.println("<h2 class='success'>Welcome, " + firstname + "!</h2>");
                out.println("<p>Registration Successful.</p>");
                out.println("<a href='candlist'>View Candidate List</a>");
                out.println("</body>");
                out.println("</html>");
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}

