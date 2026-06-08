# AI-Powered Enterprise Ticket & Service Desk Automation

## Overview

AI-Powered Enterprise Ticket & Service Desk Automation is a web-based support management system developed to streamline issue tracking and service desk operations within an organization. The application allows users to create and track support tickets while enabling administrators to efficiently manage, prioritize, and resolve issues through a centralized dashboard.

The system incorporates AI-driven ticket categorization to automatically classify incoming tickets, reducing manual effort and improving response times. It also includes analytics, activity tracking, email notifications, and secure role-based authentication.

---

## Features

### User Module

* User Registration and Login
* Secure Session Management
* Create New Support Tickets
* View Submitted Tickets
* Track Ticket Status
* Receive Email Notifications on Ticket Updates
* Logout Functionality

### Admin Module

* Admin Login Authentication
* View All Tickets
* Update Ticket Status
* Resolve and Close Tickets
* Manage User Requests
* Dashboard Analytics
* Activity Logs Monitoring
* Logout Functionality

### AI Features

* Automatic Ticket Categorization
* Intelligent Issue Classification
* Reduced Manual Ticket Sorting

### Additional Features

* Email Notifications
* Activity Logging
* Search and Filter Functionality
* Role-Based Access Control
* Responsive User Interface

---

## Technology Stack

### Frontend

* HTML
* CSS
* JavaScript
* JSP

### Backend

* Java
* Servlets
* JDBC

### Database

* MySQL

### Server

* Apache Tomcat

### Development Tools

* Eclipse IDE
* Git
* GitHub

---

## Project Architecture

User
→ Login/Register
→ Create Ticket
→ Ticket Stored in Database
→ AI Categorization
→ Admin Dashboard
→ Ticket Status Update
→ Email Notification
→ User Receives Update

---

## Database Tables

* users
* tickets
* activity_logs

---

## Key Functionalities

### Authentication System

Provides secure registration and login for users and administrators using session management.

### Ticket Management

Users can create, view, and monitor support tickets throughout their lifecycle.

### AI-Based Categorization

Automatically categorizes incoming tickets into relevant issue categories to improve service desk efficiency.

### Admin Dashboard

Allows administrators to:

* View all tickets
* Monitor ticket statistics
* Update ticket status
* Manage service requests

### Activity Logging

Tracks important system activities for auditing and monitoring purposes.

### Email Notification System

Automatically sends email notifications when ticket status changes occur.

---

## Installation Guide

### Clone Repository

git clone https://github.com/YOUR_USERNAME/AI-Pow-Enterprise-Ticket-Service-Desk-Automation.git

### Import Project

1. Open Eclipse IDE
2. Select Import Existing Project
3. Configure Apache Tomcat Server
4. Add Project to Server

### Database Setup

1. Create MySQL Database

CREATE DATABASE enterprise_ticket_db;

2. Execute the provided SQL script.

3. Update database credentials inside:

DBConnection.java

### Run Application

Start Tomcat Server and open:

http://localhost:8080/YourProjectName

---

## Security Notes

Before running the application:

* Configure your own database credentials.
* Configure your own Gmail account for email notifications.
* Generate your own Google App Password.
* Do not commit passwords, API keys, or sensitive credentials to GitHub.

Example:

String email = "YOUR_EMAIL";
String password = "YOUR_APP_PASSWORD";

---

## Future Enhancements

* Ticket Priority Prediction using AI
* Chatbot-Based Ticket Creation
* Knowledge Base Integration
* SLA Monitoring
* Department-Based Ticket Routing
* Advanced Reporting Dashboard
* Cloud Deployment
* Mobile Application Support

---

## Learning Outcomes

Through this project, the following concepts were implemented:

* Core Java
* JSP and Servlets
* JDBC Connectivity
* MySQL Database Integration
* Session Management
* MVC Architecture
* Email Integration
* Activity Logging
* Dashboard Analytics
* AI-Based Automation
* Git and GitHub Version Control

---

## Author

Ikra Kishwar

Java Full Stack Developer

---

## License

This project is developed for educational, learning, and portfolio purposes.
