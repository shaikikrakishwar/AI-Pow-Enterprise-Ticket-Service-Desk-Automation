package com.project.controller;
import com.project.ai.SLAPredictionEngine;

import java.io.IOException;

import com.project.ai.AutoAssignEngine;
import com.project.ai.DuplicateTicketDetector;
import com.project.ai.EscalationEngine;
import com.project.ai.KnowledgeBaseEngine;
import com.project.ai.PriorityPredictor;
import com.project.ai.ResolutionEngine;
import com.project.ai.TicketCategorizer;
import com.project.dao.TicketDAO;
import com.project.model.Ticket;
import com.project.model.User;
import com.project.util.EmailUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/createTicket")
public class CreateTicketServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =
                request.getSession(false);

        if(session == null) {

            response.sendRedirect("login.jsp");
            return;
        }

        User user =
                (User) session.getAttribute("user");

        if(user == null) {

            response.sendRedirect("login.jsp");
            return;
        }

        String title =
                request.getParameter("title");

        String description =
                request.getParameter("description");

        boolean duplicate =
                DuplicateTicketDetector
                .isDuplicate(
                        title,
                        description);

        if(duplicate) {

            response.sendRedirect(
                    "dashboard?error=duplicate");

            return;
        }

        String category =
                TicketCategorizer
                .predictCategory(
                        title,
                        description);

        String priority =
                PriorityPredictor
                .predictPriority(
                        title,
                        description);

        String assignedTeam =
                AutoAssignEngine
                .assignTeam(
                        category);

        String aiSuggestion =
                ResolutionEngine
                .getSuggestion(
                        description);

        String knowledgeBase =
                KnowledgeBaseEngine
                .getSolution(
                        description);

        String escalated =
                EscalationEngine
                .checkEscalation(
                        priority,
                        "OPEN");
        
        String slaStatus =
                SLAPredictionEngine
                .predictSLA(
                        priority);


        Ticket ticket =
                new Ticket();

        ticket.setUserId(
                user.getId());

        ticket.setTitle(
                title);

        ticket.setDescription(
                description);

        ticket.setCategory(
                category);

        ticket.setPriority(
                priority);

        ticket.setStatus(
                "OPEN");

        ticket.setAssignedTeam(
                assignedTeam);

        ticket.setAiSuggestion(
                aiSuggestion);

        ticket.setKnowledgeBase(
                knowledgeBase);

        ticket.setEscalated(
                escalated);
        ticket.setSlaStatus(
                slaStatus);



        TicketDAO dao =
                new TicketDAO();

        boolean status =
                dao.createTicket(
                        ticket);

        if(status) {

            EmailUtil.sendEmail(
                    user.getEmail(),
                    "Ticket Created Successfully",
                    "Ticket: " + title
                    + "\nCategory: " + category
                    + "\nPriority: " + priority
                    + "\nAssigned Team: " + assignedTeam
                    + "\nEscalated: " + escalated);

            response.sendRedirect(
                    "dashboard?success=ticket");

        } else {

            response.sendRedirect(
                    "dashboard?error=ticket");
        }
    }
}