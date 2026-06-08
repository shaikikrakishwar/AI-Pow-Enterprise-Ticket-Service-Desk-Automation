package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.model.Ticket;
import com.project.util.DBConnection;

public class TicketDAO {


private Connection con;

public TicketDAO() {

    con = DBConnection.getConnection();
}

public boolean createTicket(Ticket ticket) {

    boolean status = false;

    try {

        String sql =
        "INSERT INTO tickets("
        + "user_id,"
        + "title,"
        + "description,"
        + "category,"
        + "priority,"
        + "status,"
        + "assigned_team,"
        + "ai_suggestion,"
        + "escalated,"
        + "knowledge_base,"
        + "duplicate_ticket,"
        + "sla_status)"
        + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setInt(1,
                ticket.getUserId());

        ps.setString(2,
                ticket.getTitle());

        ps.setString(3,
                ticket.getDescription());

        ps.setString(4,
                ticket.getCategory());

        ps.setString(5,
                ticket.getPriority());

        ps.setString(6,
                ticket.getStatus());

        ps.setString(7,
                ticket.getAssignedTeam());

        ps.setString(8,
                ticket.getAiSuggestion());

        ps.setString(9,
                ticket.getEscalated());

        ps.setString(10,
                ticket.getKnowledgeBase());

        ps.setString(11,
                ticket.getDuplicateTicket());

        ps.setString(12,
                ticket.getSlaStatus());

        int rows =
                ps.executeUpdate();

        if(rows > 0) {

            status = true;
        }

    } catch(Exception e) {

        e.printStackTrace();
    }

    return status;
}

public List<Ticket> getAllTickets() {

    List<Ticket> tickets =
            new ArrayList<>();

    try {

        String sql =
                "SELECT * FROM tickets";

        PreparedStatement ps =
                con.prepareStatement(sql);

        ResultSet rs =
                ps.executeQuery();

        while(rs.next()) {

            Ticket ticket =
                    new Ticket();

            ticket.setId(
                    rs.getInt("ticket_id"));

            ticket.setUserId(
                    rs.getInt("user_id"));

            ticket.setTitle(
                    rs.getString("title"));

            ticket.setDescription(
                    rs.getString("description"));

            ticket.setCategory(
                    rs.getString("category"));

            ticket.setPriority(
                    rs.getString("priority"));

            ticket.setStatus(
                    rs.getString("status"));

            ticket.setAssignedTeam(
                    rs.getString("assigned_team"));

            ticket.setAiSuggestion(
                    rs.getString("ai_suggestion"));

            ticket.setKnowledgeBase(
                    rs.getString("knowledge_base"));

            ticket.setDuplicateTicket(
                    rs.getString("duplicate_ticket"));

            ticket.setSlaStatus(
                    rs.getString("sla_status"));

            ticket.setEscalated(
                    rs.getString("escalated"));

            tickets.add(ticket);
        }

    } catch(Exception e) {

        e.printStackTrace();
    }

    return tickets;
}

public boolean updateTicketStatus(
        int ticketId,
        String status) {

    boolean result = false;

    try {

        String sql =
                "UPDATE tickets SET status=? WHERE ticket_id=?";

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setString(1,
                status);

        ps.setInt(2,
                ticketId);

        int rows =
                ps.executeUpdate();

        if(rows > 0) {

            result = true;
        }

    } catch(Exception e) {

        e.printStackTrace();
    }

    return result;
}

public Ticket getTicketById(int ticketId) {

    Ticket ticket = null;

    try {

        String sql =
                "SELECT * FROM tickets WHERE ticket_id=?";

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setInt(1, ticketId);

        ResultSet rs =
                ps.executeQuery();

        if(rs.next()) {

            ticket = new Ticket();

            ticket.setId(
                    rs.getInt("ticket_id"));

            ticket.setUserId(
                    rs.getInt("user_id"));

            ticket.setTitle(
                    rs.getString("title"));

            ticket.setDescription(
                    rs.getString("description"));

            ticket.setCategory(
                    rs.getString("category"));

            ticket.setPriority(
                    rs.getString("priority"));

            ticket.setStatus(
                    rs.getString("status"));

            ticket.setAssignedTeam(
                    rs.getString("assigned_team"));

            ticket.setAiSuggestion(
                    rs.getString("ai_suggestion"));

            ticket.setKnowledgeBase(
                    rs.getString("knowledge_base"));

            ticket.setDuplicateTicket(
                    rs.getString("duplicate_ticket"));

            ticket.setSlaStatus(
                    rs.getString("sla_status"));

            ticket.setEscalated(
                    rs.getString("escalated"));
        }

    } catch(Exception e) {

        e.printStackTrace();
    }

    return ticket;
}

public int getTicketCountByStatus(
        int userId,
        String status) {

    int count = 0;

    try {

        PreparedStatement ps =
                con.prepareStatement(
                "SELECT COUNT(*) FROM tickets WHERE user_id=? AND status=?");

        ps.setInt(1,
                userId);

        ps.setString(2,
                status);

        ResultSet rs =
                ps.executeQuery();

        if(rs.next()) {

            count =
                    rs.getInt(1);
        }

    } catch(Exception e) {

        e.printStackTrace();
    }

    return count;
}

public int getTotalTicketsByUserId(
        int userId) {

    int count = 0;

    try {

        PreparedStatement ps =
                con.prepareStatement(
                "SELECT COUNT(*) FROM tickets WHERE user_id=?");

        ps.setInt(1,
                userId);

        ResultSet rs =
                ps.executeQuery();

        if(rs.next()) {

            count =
                    rs.getInt(1);
        }

    } catch(Exception e) {

        e.printStackTrace();
    }

    return count;
}

public boolean reopenTicket(
        int ticketId) {

    boolean status = false;

    try {

        String sql =
                "UPDATE tickets SET status='REOPENED' WHERE ticket_id=?";

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setInt(1,
                ticketId);

        int rows =
                ps.executeUpdate();

        if(rows > 0) {

            status = true;
        }

    } catch(Exception e) {

        e.printStackTrace();
    }

    return status;
}

public int getAtRiskTicketCount() {

    int count = 0;

    try {

        PreparedStatement ps =
                con.prepareStatement(
                "SELECT COUNT(*) FROM tickets WHERE sla_status='AT_RISK'");

        ResultSet rs =
                ps.executeQuery();

        if(rs.next()) {

            count =
                    rs.getInt(1);
        }

    } catch(Exception e) {

        e.printStackTrace();
    }

    return count;
}

public List<Ticket> getTicketsByUserId(
        int userId) {

    List<Ticket> tickets =
            new ArrayList<>();

    try {

        String sql =
                "SELECT * FROM tickets WHERE user_id=?";

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setInt(1,
                userId);

        ResultSet rs =
                ps.executeQuery();

        while(rs.next()) {

            Ticket ticket =
                    new Ticket();

            ticket.setId(
                    rs.getInt("ticket_id"));

            ticket.setUserId(
                    rs.getInt("user_id"));

            ticket.setTitle(
                    rs.getString("title"));

            ticket.setDescription(
                    rs.getString("description"));

            ticket.setCategory(
                    rs.getString("category"));

            ticket.setPriority(
                    rs.getString("priority"));

            ticket.setStatus(
                    rs.getString("status"));

            ticket.setAssignedTeam(
                    rs.getString("assigned_team"));

            ticket.setAiSuggestion(
                    rs.getString("ai_suggestion"));

            ticket.setKnowledgeBase(
                    rs.getString("knowledge_base"));

            ticket.setDuplicateTicket(
                    rs.getString("duplicate_ticket"));

            ticket.setSlaStatus(
                    rs.getString("sla_status"));

            ticket.setEscalated(
                    rs.getString("escalated"));

            tickets.add(ticket);
        }

    } catch(Exception e) {

        e.printStackTrace();
    }

    return tickets;
}
public String getUserEmailByTicketId(
        int ticketId) {

    String email = null;

    try {

        String sql =
                "SELECT u.email " +
                "FROM users u " +
                "INNER JOIN tickets t " +
                "ON u.id = t.user_id " +
                "WHERE t.ticket_id = ?";

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setInt(1,
                ticketId);

        ResultSet rs =
                ps.executeQuery();

        if(rs.next()) {

            email =
                    rs.getString("email");
        }

    } catch(Exception e) {

        e.printStackTrace();
    }

    return email;
}

public String getTicketStatus(
        int ticketId) {

    String status = null;

    try {

        PreparedStatement ps =
        con.prepareStatement(
        "SELECT status "
        + "FROM tickets "
        + "WHERE ticket_id=?");

        ps.setInt(
                1,
                ticketId);

        ResultSet rs =
                ps.executeQuery();

        if(rs.next()) {

            status =
            rs.getString(
            "status");
        }

    } catch(Exception e) {

        e.printStackTrace();
    }

    return status;
}
public List<Ticket> getFilteredTickets(
String status,
String priority,
String category) {

List<Ticket> tickets =
        new ArrayList<>();

try {

    String sql =
            "SELECT * FROM tickets WHERE 1=1";

    if(status != null &&
            !status.isEmpty()) {

        sql += " AND status=?";
    }

    if(priority != null &&
            !priority.isEmpty()) {

        sql += " AND priority=?";
    }

    if(category != null &&
            !category.isEmpty()) {

        sql += " AND category=?";
    }

    PreparedStatement ps =
            con.prepareStatement(sql);

    int index = 1;

    if(status != null &&
            !status.isEmpty()) {

        ps.setString(
                index++,
                status);
    }

    if(priority != null &&
            !priority.isEmpty()) {

        ps.setString(
                index++,
                priority);
    }

    if(category != null &&
            !category.isEmpty()) {

        ps.setString(
                index++,
                category);
    }

    ResultSet rs =
            ps.executeQuery();

    while(rs.next()) {

        Ticket ticket =
                new Ticket();

        ticket.setId(
                rs.getInt("ticket_id"));

        ticket.setUserId(
                rs.getInt("user_id"));

        ticket.setTitle(
                rs.getString("title"));

        ticket.setDescription(
                rs.getString("description"));

        ticket.setCategory(
                rs.getString("category"));

        ticket.setPriority(
                rs.getString("priority"));

        ticket.setStatus(
                rs.getString("status"));

        ticket.setAssignedTeam(
                rs.getString("assigned_team"));

        ticket.setAiSuggestion(
                rs.getString("ai_suggestion"));

        ticket.setKnowledgeBase(
                rs.getString("knowledge_base"));

        ticket.setDuplicateTicket(
                rs.getString("duplicate_ticket"));

        ticket.setSlaStatus(
                rs.getString("sla_status"));

        ticket.setEscalated(
                rs.getString("escalated"));

        tickets.add(ticket);
    }

} catch(Exception e) {

    e.printStackTrace();
}

return tickets;

}



}
