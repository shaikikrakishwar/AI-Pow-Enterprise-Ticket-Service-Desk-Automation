package com.project.controller;

import java.io.IOException;

import com.project.dao.TicketDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/reopenTicket")
public class ReopenTicketServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        int ticketId =
                Integer.parseInt(
                        request.getParameter(
                                "ticketId"));

        TicketDAO dao =
                new TicketDAO();

        dao.reopenTicket(
                ticketId);

        response.sendRedirect(
                "myTickets");
    }
}
