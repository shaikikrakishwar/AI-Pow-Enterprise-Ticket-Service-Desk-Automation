package com.project.model;

import java.sql.Timestamp;

public class TicketComment {

    private int commentId;

    private int ticketId;

    private String userName;

    private String commentText;

    private Timestamp commentDate;

    public TicketComment() {

    }

    public int getCommentId() {

        return commentId;
    }

    public void setCommentId(
            int commentId) {

        this.commentId =
                commentId;
    }

    public int getTicketId() {

        return ticketId;
    }

    public void setTicketId(
            int ticketId) {

        this.ticketId =
                ticketId;
    }

    public String getUserName() {

        return userName;
    }

    public void setUserName(
            String userName) {

        this.userName =
                userName;
    }

    public String getCommentText() {

        return commentText;
    }

    public void setCommentText(
            String commentText) {

        this.commentText =
                commentText;
    }

    public Timestamp getCommentDate() {

        return commentDate;
    }

    public void setCommentDate(
            Timestamp commentDate) {

        this.commentDate =
                commentDate;
    }
}