package com.project.controller;

import java.io.IOException;

import com.project.dao.UserDAO;
import com.project.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String name =
                request.getParameter("name");

        String email =
                request.getParameter("email");

        String password =
                request.getParameter("password");

        String department =
                request.getParameter("department");

        User user =
                new User();

        user.setName(name);

        user.setEmail(email);

        user.setPassword(password);

        user.setDepartment(department);

        user.setRole("EMPLOYEE");

        UserDAO dao =
                new UserDAO();

        boolean status =
                dao.registerUser(user);

        if(status) {

            response.sendRedirect(
                    "login.jsp?success=register");

        } else {

            response.sendRedirect(
                    "register.jsp?error=register");
        }
    }
}