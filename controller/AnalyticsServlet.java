package com.project.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.project.model.User;
import com.project.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/analytics")
public class AnalyticsServlet extends HttpServlet {
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

    try {

        Connection con =
                DBConnection.getConnection();

        int totalTickets = 0;
        int openTickets = 0;
        int closedTickets = 0;
        int highPriority = 0;
        int atRiskTickets = 0;

        int networkCount = 0;
        int softwareCount = 0;
        int hardwareCount = 0;
        int accessCount = 0;

        int highCount = 0;
        int mediumCount = 0;
        int lowCount = 0;

        PreparedStatement ps1 =
                con.prepareStatement(
                "SELECT COUNT(*) FROM tickets");

        ResultSet rs1 =
                ps1.executeQuery();

        if(rs1.next()) {

            totalTickets =
                    rs1.getInt(1);
        }

        PreparedStatement ps2 =
                con.prepareStatement(
                "SELECT COUNT(*) FROM tickets WHERE status='OPEN'");

        ResultSet rs2 =
                ps2.executeQuery();

        if(rs2.next()) {

            openTickets =
                    rs2.getInt(1);
        }

        PreparedStatement ps3 =
                con.prepareStatement(
                "SELECT COUNT(*) FROM tickets WHERE status='CLOSED'");

        ResultSet rs3 =
                ps3.executeQuery();

        if(rs3.next()) {

            closedTickets =
                    rs3.getInt(1);
        }

        PreparedStatement ps4 =
                con.prepareStatement(
                "SELECT COUNT(*) FROM tickets WHERE priority='HIGH'");

        ResultSet rs4 =
                ps4.executeQuery();

        if(rs4.next()) {

            highPriority =
                    rs4.getInt(1);
        }

        PreparedStatement ps5 =
                con.prepareStatement(
                "SELECT COUNT(*) FROM tickets WHERE sla_status='AT_RISK'");

        ResultSet rs5 =
                ps5.executeQuery();

        if(rs5.next()) {

            atRiskTickets =
                    rs5.getInt(1);
        }

        PreparedStatement ps6 =
                con.prepareStatement(
                "SELECT category, COUNT(*) total FROM tickets GROUP BY category");

        ResultSet rs6 =
                ps6.executeQuery();

        while(rs6.next()) {

            String category =
                    rs6.getString("category");

            int count =
                    rs6.getInt("total");

            if("NETWORK".equalsIgnoreCase(category))
                networkCount = count;

            else if("SOFTWARE".equalsIgnoreCase(category))
                softwareCount = count;

            else if("HARDWARE".equalsIgnoreCase(category))
                hardwareCount = count;

            else if("ACCESS".equalsIgnoreCase(category))
                accessCount = count;
        }
        PreparedStatement ps8 =
        		con.prepareStatement(
        		"SELECT COUNT(*) FROM tickets WHERE created_at < NOW() - INTERVAL 3 DAY");

        		ResultSet rs8 =
        		ps8.executeQuery();

        		int olderThan3Days = 0;

        		if(rs8.next()){

        		    olderThan3Days =
        		    rs8.getInt(1);
        		}

        		PreparedStatement ps9 =
        		con.prepareStatement(
        		"SELECT COUNT(*) FROM tickets WHERE created_at < NOW() - INTERVAL 7 DAY");

        		ResultSet rs9 =
        		ps9.executeQuery();

        		int olderThan7Days = 0;

        		if(rs9.next()){

        		    olderThan7Days =
        		    rs9.getInt(1);
        		}

        		PreparedStatement ps10 =
        		con.prepareStatement(
        		"SELECT COUNT(*) FROM tickets WHERE created_at < NOW() - INTERVAL 15 DAY");

        		ResultSet rs10 =
        		ps10.executeQuery();

        		int olderThan15Days = 0;

        		if(rs10.next()){

        		    olderThan15Days =
        		    rs10.getInt(1);
        		}

        PreparedStatement ps7 =
                con.prepareStatement(
                "SELECT priority, COUNT(*) total FROM tickets GROUP BY priority");

        ResultSet rs7 =
                ps7.executeQuery();

        while(rs7.next()) {

            String priority =
                    rs7.getString("priority");

            int count =
                    rs7.getInt("total");

            if("HIGH".equalsIgnoreCase(priority))
                highCount = count;

            else if("MEDIUM".equalsIgnoreCase(priority))
                mediumCount = count;

            else if("LOW".equalsIgnoreCase(priority))
                lowCount = count;
        }

        request.setAttribute(
                "totalTickets",
                totalTickets);

        request.setAttribute(
                "openTickets",
                openTickets);

        request.setAttribute(
                "closedTickets",
                closedTickets);

        request.setAttribute(
                "highPriority",
                highPriority);

        request.setAttribute(
                "atRiskTickets",
                atRiskTickets);

        request.setAttribute(
                "networkCount",
                networkCount);

        request.setAttribute(
                "softwareCount",
                softwareCount);

        request.setAttribute(
                "hardwareCount",
                hardwareCount);

        request.setAttribute(
                "accessCount",
                accessCount);

        request.setAttribute(
                "highCount",
                highCount);

        request.setAttribute(
                "mediumCount",
                mediumCount);

        request.setAttribute(
                "lowCount",
                lowCount);
        request.setAttribute(
        		"olderThan3Days",
        		olderThan3Days);

        		request.setAttribute(
        		"olderThan7Days",
        		olderThan7Days);

        		request.setAttribute(
        		"olderThan15Days",
        		olderThan15Days);

        request.getRequestDispatcher(
                "analytics.jsp")
                .forward(
                        request,
                        response);

    } catch(Exception e) {

        e.printStackTrace();
    }
}

}
