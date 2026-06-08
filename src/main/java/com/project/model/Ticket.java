package com.project.model;

public class Ticket {

    private int id;
    private int userId;

    private String title;
    private String description;
    private String category;
    private String priority;
    private String status;
    private String duplicateTicket;
    private String slaStatus;

    private String assignedTeam;

    private String aiSuggestion;
    private String escalated;
    private String knowledgeBase;

    public Ticket() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSlaStatus() {

        return slaStatus;
    }
    public void setSlaStatus(
            String slaStatus) {

        this.slaStatus =
                slaStatus;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuplicateTicket() {
        return duplicateTicket;
    }

    public void setDuplicateTicket(
            String duplicateTicket) {

        this.duplicateTicket =
                duplicateTicket;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
    
    public String getKnowledgeBase() {
        return knowledgeBase;
    }

    public void setKnowledgeBase(String knowledgeBase) {
        this.knowledgeBase = knowledgeBase;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssignedTeam() {
        return assignedTeam;
    }

    public void setAssignedTeam(String assignedTeam) {
        this.assignedTeam = assignedTeam;
    }

    public String getAiSuggestion() {
        return aiSuggestion;
    }

    public void setAiSuggestion(String aiSuggestion) {
        this.aiSuggestion = aiSuggestion;
    }
    
    public String getEscalated() {
        return escalated;
    }

    public void setEscalated(String escalated) {
        this.escalated = escalated;
    }
}