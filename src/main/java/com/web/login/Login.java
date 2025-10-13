package com.web.login;


import com.web.login.dao.LoginDao;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/login")
public class Login extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");

        LoginDao dao = new LoginDao();
        try {
            if(dao.check(name,pass)){
                HttpSession session = request.getSession();
                session.setAttribute("username",name);
                response.sendRedirect("welcome.jsp");
            }else{
                response.sendRedirect("/LoginPage");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
