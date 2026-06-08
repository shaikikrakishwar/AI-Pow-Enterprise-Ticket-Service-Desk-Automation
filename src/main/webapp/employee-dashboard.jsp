<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="com.project.model.User" %>

<!DOCTYPE html>

<html>
<head>

<meta charset="UTF-8">

<link rel="icon" type="image/png"
href="images/favicon.png">
<link rel="stylesheet"
href="css/style.css">
<title>Employee Dashboard</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Segoe UI',sans-serif;
}

body{

    min-height:100vh;

    background:linear-gradient(
        135deg,
        #1f4037,
        #3b5d50,
        #233329
    );

    color:white;
}

.success{

    width:90%;

    margin:20px auto;

    padding:15px;

    border-radius:12px;

    background:#27ae60;

    text-align:center;

    font-weight:bold;
}

.error{

    width:90%;

    margin:20px auto;

    padding:15px;

    border-radius:12px;

    background:#e74c3c;

    text-align:center;

    font-weight:bold;
}

.navbar{

    width:90%;

    margin:20px auto;

    display:flex;

    justify-content:space-between;

    align-items:center;

    padding:15px 30px;

    background:rgba(255,255,255,0.08);

    backdrop-filter:blur(3px);

    border-radius:20px;
}

.logo{

    font-size:24px;

    font-weight:bold;
}

.menu a{

    color:white;

    text-decoration:none;

    margin-left:25px;
}

.hero{

    text-align:center;

    margin-top:60px;
}

.hero h1{

    font-size:52px;

    margin-bottom:15px;
}

.hero p{

    color:#dddddd;

    font-size:18px;
}

.cards{

    width:90%;

    margin:60px auto;

    display:grid;

    grid-template-columns:
    repeat(auto-fit,minmax(220px,1fr));

    gap:25px;
}

.card{

    padding:25px;

    border-radius:20px;

    background:rgba(255,255,255,0.08);

    backdrop-filter:blur(12px);

    box-shadow:
    0 8px 25px rgba(0,0,0,0.2);
}

.card h2{

    font-size:34px;

    margin-bottom:10px;
}

.card p{

    color:#e0e0e0;
}

.actions{

    width:90%;

    margin:auto;

    display:flex;

    justify-content:center;

    gap:20px;

    flex-wrap:wrap;
}

.btn{

    padding:15px 30px;

    border:none;

    border-radius:12px;

    background:white;

    cursor:pointer;

    font-weight:bold;

    text-decoration:none;

    color:black;
}

</style>

</head>

<%
User user =
(User)session.getAttribute("user");

String success =
request.getParameter("success");

String error =
request.getParameter("error");
%>

<body>



<%
if("ticket".equals(success)){
%>

<div class="success">
✓ Ticket Created Successfully
</div>

<%
}
%>

<%
if("ticket".equals(error)){
%>

<div class="error">
✗ Ticket Creation Failed
</div>

<%
}
%>

<%
if("duplicate".equals(error)){
%>

<div class="error">
⚠ Duplicate Ticket Found. Please check your existing ticket.
</div>

<%
}
%>

<div class="navbar">

<div class="logo">

AI-Powered Desk

</div>

<div class="menu">

<a href="dashboard">
Dashboard
</a>

<a href="create-ticket.jsp">
Create Ticket
</a>

<a href="myTickets">
My Tickets
</a>

<a href="ai-assistant.jsp">
AI Assistant
</a>

<a href="logout"
onclick="return confirm('Are you sure you want to logout?');">

Logout

</a>

</div>

</div>

<div class="hero">

<h1>

Welcome Back,
<%=user.getName()%>

</h1>

<p>

AI Powered Enterprise Ticket &
Service Desk Automation

</p>

</div>

<div class="cards">

<div class="card">
    <h2>${totalTickets}</h2>
    <p>Total Tickets</p>
</div>

<div class="card">
    <h2>${openTickets}</h2>
    <p>Open Tickets</p>
</div>

<div class="card">
    <h2>${inProgressTickets}</h2>
    <p>In Progress</p>
</div>

<div class="card">
    <h2>${resolvedTickets}</h2>
    <p>Resolved</p>
</div>

</div>

<div class="actions">

<a href="create-ticket.jsp"
class="btn">

Create Ticket

</a>

<a href="myTickets"
class="btn">

View My Tickets

</a>

<a href="ai-assistant.jsp"
class="btn">

AI Assistant

</a>

</div>

</body>
</html>
