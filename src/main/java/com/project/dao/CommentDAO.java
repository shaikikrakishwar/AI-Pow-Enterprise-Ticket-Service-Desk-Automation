package com.project.dao;

import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.model.TicketComment;
import com.project.util.DBConnection;

public class CommentDAO {

    private Connection con;

    public CommentDAO() {

        con = DBConnection.getConnection();
    }

    public boolean addComment(
            TicketComment comment) {

        boolean status = false;

        try {

            String sql =
                    "INSERT INTO ticket_comments("
                    + "ticket_id,"
                    + "user_name,"
                    + "comment_text)"
                    + "VALUES(?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(
                    1,
                    comment.getTicketId());

            ps.setString(
                    2,
                    comment.getUserName());

            ps.setString(
                    3,
                    comment.getCommentText());

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
    public String getLastActivity(int ticketId) {

        String lastActivity = "-";

        try {

            String sql =
                    "SELECT MAX(comment_date) "
                    + "FROM ticket_comments "
                    + "WHERE ticket_id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, ticketId);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {

                Timestamp ts =
                        rs.getTimestamp(1);

                if(ts != null) {

                    lastActivity =
                            ts.toString();
                }
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return lastActivity;
    }
    public int getCommentCount(int ticketId) {

        int count = 0;

        try {

            String sql =
            "SELECT COUNT(*) FROM ticket_comments WHERE ticket_id=?";

            PreparedStatement ps =
            con.prepareStatement(sql);

            ps.setInt(1, ticketId);

            ResultSet rs =
            ps.executeQuery();

            if(rs.next()) {

                count = rs.getInt(1);
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return count;
    }
    public boolean hasComments(int ticketId) {

        boolean hasComments = false;

        try {

            String sql =
                    "SELECT COUNT(*) FROM ticket_comments "
                    + "WHERE ticket_id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, ticketId);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {

                hasComments =
                        rs.getInt(1) > 0;
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return hasComments;
    }
    public List<TicketComment>
    getCommentsByTicketId(
            int ticketId) {

        List<TicketComment>
        comments =
        new ArrayList<>();

        try {

            String sql =
                    "SELECT * FROM ticket_comments "
                    + "WHERE ticket_id=? "
                    + "ORDER BY comment_date ASC";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(
                    1,
                    ticketId);

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()) {

                TicketComment comment =
                        new TicketComment();

                comment.setCommentId(
                        rs.getInt(
                        "comment_id"));

                comment.setTicketId(
                        rs.getInt(
                        "ticket_id"));

                comment.setUserName(
                        rs.getString(
                        "user_name"));

                comment.setCommentText(
                        rs.getString(
                        "comment_text"));

                comment.setCommentDate(
                        rs.getTimestamp(
                        "comment_date"));

                comments.add(
                        comment);
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return comments;
    }
}