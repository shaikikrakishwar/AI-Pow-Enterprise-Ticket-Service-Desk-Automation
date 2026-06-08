package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.model.ActivityLog;
import com.project.util.DBConnection;

public class ActivityLogDAO {

    private Connection con;

    public ActivityLogDAO() {

        con = DBConnection.getConnection();
    }

    public void saveLog(
            ActivityLog log) {

        try {

            String sql =
            "INSERT INTO activity_logs("
            + "ticket_id,"
            + "admin_name,"
            + "old_status,"
            + "new_status)"
            + "VALUES(?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(
                    1,
                    log.getTicketId());

            ps.setString(
                    2,
                    log.getAdminName());

            ps.setString(
                    3,
                    log.getOldStatus());

            ps.setString(
                    4,
                    log.getNewStatus());

            ps.executeUpdate();

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

    public List<ActivityLog>
    getAllLogs() {

        List<ActivityLog> logs =
                new ArrayList<>();

        try {

            String sql =
            "SELECT * FROM activity_logs "
            + "ORDER BY action_time DESC";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()) {

                ActivityLog log =
                        new ActivityLog();

                log.setLogId(
                        rs.getInt("log_id"));

                log.setTicketId(
                        rs.getInt("ticket_id"));

                log.setAdminName(
                        rs.getString("admin_name"));

                log.setOldStatus(
                        rs.getString("old_status"));

                log.setNewStatus(
                        rs.getString("new_status"));

                log.setActionTime(
                        rs.getTimestamp(
                        "action_time"));

                logs.add(log);
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return logs;
    }
}