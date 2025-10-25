package com.web.login;

import com.web.login.dao.RegisterDao;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/register")
public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");

        RegisterDao dao = new RegisterDao();
        try {
            if(dao.register(name,pass))
                response.sendRedirect("/LoginPage");
            else
                response.sendRedirect("register.jsp");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
