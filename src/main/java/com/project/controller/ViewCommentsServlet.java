package com.project.controller;

import java.io.IOException;
import java.util.List;

import com.project.dao.CommentDAO;
import com.project.model.TicketComment;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewComments")
public class ViewCommentsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int ticketId =
                    Integer.parseInt(
                    request.getParameter(
                            "ticketId"));

            CommentDAO dao =
                    new CommentDAO();

            List<TicketComment> comments =
                    dao.getCommentsByTicketId(
                            ticketId);

            request.setAttribute(
                    "ticketId",
                    ticketId);

            request.setAttribute(
                    "comments",
                    comments);

            request.getRequestDispatcher(
                    "view-comments.jsp")
                    .forward(
                            request,
                            response);

        } catch(Exception e) {

            e.printStackTrace();

            response.sendRedirect(
                    "adminDashboard");
        }
    }
}