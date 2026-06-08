package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.project.dao.TicketDAO;
import com.project.model.Ticket;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/exportTickets")
public class ExportTicketsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/csv");

        response.setHeader(
                "Content-Disposition",
                "attachment; filename=tickets.csv");

        TicketDAO dao =
                new TicketDAO();

        List<Ticket> tickets =
                dao.getAllTickets();

        PrintWriter out =
                response.getWriter();

        out.println(
                "Ticket ID,User ID,Title,Category,Priority,Status,Assigned Team");

        for(Ticket ticket : tickets) {

            out.println(
                    ticket.getId() + "," +
                    ticket.getUserId() + "," +
                    ticket.getTitle() + "," +
                    ticket.getCategory() + "," +
                    ticket.getPriority() + "," +
                    ticket.getStatus() + "," +
                    ticket.getAssignedTeam());
        }

        out.flush();
        out.close();
    }
}