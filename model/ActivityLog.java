package com.project.model;

import java.sql.Timestamp;

public class ActivityLog {

    private int logId;

    private int ticketId;

    private String adminName;

    private String oldStatus;

    private String newStatus;

    private Timestamp actionTime;

    public int getLogId() {

        return logId;
    }

    public void setLogId(int logId) {

        this.logId = logId;
    }

    public int getTicketId() {

        return ticketId;
    }

    public void setTicketId(int ticketId) {

        this.ticketId = ticketId;
    }

    public String getAdminName() {

        return adminName;
    }

    public void setAdminName(String adminName) {

        this.adminName = adminName;
    }

    public String getOldStatus() {

        return oldStatus;
    }

    public void setOldStatus(String oldStatus) {

        this.oldStatus = oldStatus;
    }

    public String getNewStatus() {

        return newStatus;
    }

    public void setNewStatus(String newStatus) {

        this.newStatus = newStatus;
    }

    public Timestamp getActionTime() {

        return actionTime;
    }

    public void setActionTime(
            Timestamp actionTime) {

        this.actionTime =
                actionTime;
    }
}