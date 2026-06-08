package com.project.controller;

import java.io.IOException;

import com.project.dao.TicketDAO;
import com.project.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =
                request.getSession(false);

        if(session == null) {

            response.sendRedirect(
                    "login.jsp");

            return;
        }

        User user =
                (User) session.getAttribute(
                        "user");

        if(user == null) {

            response.sendRedirect(
                    "login.jsp");

            return;
        }

        TicketDAO dao =
                new TicketDAO();

        int totalTickets =
                dao.getTotalTicketsByUserId(
                        user.getId());

        int openTickets =
                dao.getTicketCountByStatus(
                        user.getId(),
                        "OPEN");

        int inProgressTickets =
                dao.getTicketCountByStatus(
                        user.getId(),
                        "IN_PROGRESS");

        int resolvedTickets =
                dao.getTicketCountByStatus(
                        user.getId(),
                        "RESOLVED");

        request.setAttribute(
                "totalTickets",
                totalTickets);

        request.setAttribute(
                "openTickets",
                openTickets);

        request.setAttribute(
                "inProgressTickets",
                inProgressTickets);

        request.setAttribute(
                "resolvedTickets",
                resolvedTickets);

        request.getRequestDispatcher(
                "employee-dashboard.jsp")
                .forward(
                        request,
                        response);
    }
}