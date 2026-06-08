package com.project.controller;

import java.io.IOException;
import java.util.List;

import com.project.dao.TicketDAO;
import com.project.model.Ticket;
import com.project.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/myTickets")
public class ViewMyTicketsServlet extends HttpServlet {

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

        List<Ticket> tickets =
                dao.getTicketsByUserId(
                        user.getId());

        request.setAttribute(
                "tickets",
                tickets);

        request.getRequestDispatcher(
                "my-tickets.jsp")
                .forward(
                        request,
                        response);
    }
}