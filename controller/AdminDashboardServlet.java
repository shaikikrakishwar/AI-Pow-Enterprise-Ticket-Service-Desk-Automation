package com.project.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.project.dao.CommentDAO;
import com.project.dao.TicketDAO;
import com.project.model.Ticket;
import com.project.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/adminDashboard")
public class AdminDashboardServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
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

        if(!"ADMIN".equalsIgnoreCase(
                user.getRole())) {

            response.sendRedirect(
                    "dashboard");

            return;
        }

        String status =
                request.getParameter(
                        "status");

        String priority =
                request.getParameter(
                        "priority");

        String category =
                request.getParameter(
                        "category");

        TicketDAO dao =
                new TicketDAO();

        List<Ticket> tickets;

        if((status != null &&
                !status.isEmpty())
                ||
           (priority != null &&
                !priority.isEmpty())
                ||
           (category != null &&
                !category.isEmpty())) {

            tickets =
                    dao.getFilteredTickets(
                            status,
                            priority,
                            category);

        } else {

            tickets =
                    dao.getAllTickets();
        }

        CommentDAO commentDAO =
                new CommentDAO();

        Map<Integer, Boolean> commentMap =
                new HashMap<>();
        Map<Integer, Integer> commentCountMap =
                new HashMap<>();
        Map<Integer, String> lastActivityMap =
                new HashMap<>();

        for(Ticket ticket : tickets) {

            commentMap.put(
                    ticket.getId(),
                    commentDAO.hasComments(
                            ticket.getId()));

            commentCountMap.put(
                    ticket.getId(),
                    commentDAO.getCommentCount(
                            ticket.getId()));
            lastActivityMap.put(
                    ticket.getId(),
                    commentDAO.getLastActivity(
                            ticket.getId()));
        }
        request.setAttribute(
                "tickets",
                tickets);

        request.setAttribute(
                "commentMap",
                commentMap);
        request.setAttribute(
                "commentCountMap",
                commentCountMap);
        request.setAttribute(
                "lastActivityMap",
                lastActivityMap);

        request.getRequestDispatcher(
                "admin-dashboard.jsp")
                .forward(
                        request,
                        response);
    }
}