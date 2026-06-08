package com.project.controller;

import java.io.IOException;

import com.project.dao.CommentDAO;
import com.project.model.TicketComment;
import com.project.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addComment")
public class AddCommentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String ticketIdParam =
                request.getParameter("ticketId");

        String commentText =
                request.getParameter("commentText");

        if (ticketIdParam == null ||
            commentText == null ||
            commentText.trim().isEmpty()) {

            response.sendRedirect("dashboard");
            return;
        }

        int ticketId =
                Integer.parseInt(ticketIdParam);

        TicketComment comment =
                new TicketComment();

        comment.setTicketId(ticketId);
        comment.setUserName(user.getName());
        comment.setCommentText(commentText.trim());

        CommentDAO dao = new CommentDAO();

        dao.addComment(comment);

        response.sendRedirect(
                "viewComments?ticketId="
                + ticketId);
    }
}