package com.project.controller;

import java.io.IOException;

import com.project.dao.UserDAO;
import com.project.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String email =
                request.getParameter("email");

        String password =
                request.getParameter("password");

        UserDAO dao =
                new UserDAO();

        User user =
                dao.loginUser(
                        email,
                        password);

        if(user != null) {

            HttpSession session =
                    request.getSession();

            session.setAttribute(
                    "user",
                    user);

            if("ADMIN".equalsIgnoreCase(
                    user.getRole())) {

                response.sendRedirect(
                        "adminDashboard");

            } else {

                response.sendRedirect(
                        "dashboard");
            }

        } else {

            response.sendRedirect(
                    "login.jsp?error=login");
        }
    }
}