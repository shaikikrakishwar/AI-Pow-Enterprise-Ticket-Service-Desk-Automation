<%@ page import="java.util.List" %>
<%@ page import="com.project.model.Ticket" %>

<!DOCTYPE html>

<html>
<head>

<meta charset="UTF-8">

<link rel="icon" type="image/png"
href="images/favicon.png">

<link rel="stylesheet"
href="css/style.css">

<title>My Tickets</title>

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

    padding:30px;
}

.container{

    width:98%;

    margin:auto;
}

h1{

    text-align:center;

    margin-bottom:25px;
}

table{

    width:100%;

    border-collapse:collapse;

    background:rgba(255,255,255,0.08);

    backdrop-filter:blur(3px);

    border-radius:15px;

    overflow:hidden;
}

th{

    padding:12px;

    background:rgba(255,255,255,0.15);
}

td{

    padding:12px;

    text-align:center;
}

tr:nth-child(even){

    background:rgba(255,255,255,0.05);
}

.commentLink{

    color:white;

    text-decoration:none;

    font-weight:bold;
}

.commentLink:hover{

    text-decoration:underline;
}

button{

    padding:8px 15px;

    border:none;

    border-radius:8px;

    cursor:pointer;

    font-weight:bold;
}

.backBtn{

    background:white;

    padding:10px 15px;

    border-radius:10px;

    text-decoration:none;

    color:black;

    font-weight:bold;
}

</style>

</head>

<body>

<div style="margin-bottom:20px;">

<a href="dashboard"
class="backBtn">

Back to Dashboard

</a>

</div>

<div class="container">

<h1>My Tickets</h1>

<table>

<tr>

<th>ID</th>

<th>Title</th>

<th>Category</th>

<th>Priority</th>

<th>Assigned Team</th>

<th>AI Suggestion</th>

<th>Knowledge Base</th>

<th>Duplicate Check</th>

<th>Escalated</th>

<th>Status</th>

<th>Action</th>

<th>Comments</th>

</tr>

<%

List<Ticket> tickets =
(List<Ticket>)request.getAttribute(
"tickets");

if(tickets != null){

for(Ticket ticket : tickets){

%>

<tr>

<td><%=ticket.getId()%></td>

<td><%=ticket.getTitle()%></td>

<td><%=ticket.getCategory()%></td>

<td><%=ticket.getPriority()%></td>

<td><%=ticket.getAssignedTeam()%></td>

<td><%=ticket.getAiSuggestion()%></td>

<td><%=ticket.getKnowledgeBase()%></td>

<td><%=ticket.getDuplicateTicket()%></td>

<td><%=ticket.getEscalated()%></td>

<td><%=ticket.getStatus()%></td>

<td>

<%
if("CLOSED".equals(
ticket.getStatus())){
%>

<form action="reopenTicket"
method="post">

<input
type="hidden"
name="ticketId"
value="<%=ticket.getId()%>">

<button type="submit">

Reopen

</button>

</form>

<%
}
else{
%>

*

<%
}
%>

</td>

<td>

<a
href="viewComments?ticketId=<%=ticket.getId()%>"
class="commentLink">

View Comments

</a>

</td>

</tr>

<%

}
}
%>

</table>

</div>

</body>
</html>
