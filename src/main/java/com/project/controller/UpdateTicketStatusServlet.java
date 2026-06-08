package com.project.controller;

import java.io.IOException;

import com.project.dao.TicketDAO;
import com.project.util.EmailUtil;
import com.project.dao.ActivityLogDAO;
import com.project.model.ActivityLog;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateStatus")
public class UpdateTicketStatusServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int ticketId =
                    Integer.parseInt(
                    request.getParameter(
                    "ticketId"));

            String status =
                    request.getParameter(
                    "status");

            String rowId =
                    request.getParameter(
                    "rowId");

            System.out.println(
                    "Ticket ID = "
                    + ticketId);

            System.out.println(
                    "Selected Status = "
                    + status);

            TicketDAO dao =
                    new TicketDAO();
            
            String oldStatus =
                    dao.getTicketStatus(
                            ticketId);

            boolean result =
                    dao.updateTicketStatus(
                            ticketId,
                            status);
            if(result) {

                ActivityLog log =
                        new ActivityLog();

                log.setTicketId(
                        ticketId);

                log.setAdminName(
                        "ADMIN");

                log.setOldStatus(
                        oldStatus);

                log.setNewStatus(
                        status);

                ActivityLogDAO logDAO =
                        new ActivityLogDAO();

                logDAO.saveLog(
                        log);
            }

            System.out.println(
                    "Update Result = "
                    + result);

            if(result) {

                String userEmail =
                        dao.getUserEmailByTicketId(
                                ticketId);

                System.out.println(
                        "User Email = "
                        + userEmail);

                if(userEmail != null &&
                   !userEmail.trim().isEmpty()) {

                    String subject =
                            "Ticket Status Updated";

                    String message =
                            "Hello,\n\n"
                            + "Your Ticket ID "
                            + ticketId
                            + " status has been updated to "
                            + status
                            + ".\n\n"
                            + "Thank You.";

                    System.out.println(
                            "Sending Email...");

                    EmailUtil.sendEmail(
                            userEmail,
                            subject,
                            message);

                    System.out.println(
                            "Email Method Executed");
                }
                else {

                    System.out.println(
                            "Email Not Sent - User Email Not Found");
                }
            }

            response.sendRedirect(
                    "adminDashboard#ticket"
                    + rowId);

        }
        catch(Exception e) {

            System.out.println(
                    "Error While Updating Ticket");

            e.printStackTrace();

            response.sendRedirect(
                    "adminDashboard");
        }
    }
}