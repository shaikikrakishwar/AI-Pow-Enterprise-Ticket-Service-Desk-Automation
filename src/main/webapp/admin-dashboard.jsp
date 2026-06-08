<%@ page import="java.util.List" %>
<%@ page import="com.project.model.Ticket" %>
<%@ page import="java.util.Map" %>
<%
String selectedStatus =
request.getParameter("status");

String selectedPriority =
request.getParameter("priority");

String selectedCategory =
request.getParameter("category");
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport"
      content="width=device-width, initial-scale=1.0">

<link rel="icon"
type="image/png"
href="images/favicon.png">
<link rel="stylesheet"
href="css/style.css">

<title>Admin Dashboard</title>

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
.comment-btn{

    display:inline-block;

    background:#2196F3;

    color:white;

    padding:8px 12px;

    border-radius:8px;

    text-decoration:none;

    font-size:14px;

    font-weight:bold;

    min-width:100px;

    text-align:center;
}

.comment-btn:hover{

    background:#1976D2;
}
.container{

    width:99%;

    margin:auto;
}
textarea{

    width:100%;

    height:140px;

    padding:15px;

    border:none;

    border-radius:12px;

    resize:none;

    font-size:16px;
}

button{

    background:#4CAF50;

    color:white;

    border:none;

    padding:12px 25px;

    border-radius:10px;

    font-size:16px;

    font-weight:bold;

    cursor:pointer;
}
h1{

    text-align:center;

    margin-bottom:25px;
}

.top-buttons{

    display:flex;

    gap:15px;

    margin-bottom:20px;
}

.top-buttons a{

    padding:10px 20px;

    border-radius:10px;

    text-decoration:none;

    font-weight:bold;
}

.status-dropdown{

    width:130px;

    padding:8px 12px;

    border:none;

    border-radius:8px;

    background:white;

    font-weight:600;

    cursor:pointer;

    outline:none;
}
.analytics-btn{

    background:white;

    color:black;
}

.export-btn{

    background:#4CAF50;

    color:white;
}

.filter-box{

    background:
    rgba(255,255,255,0.1);

    padding:15px;

    border-radius:10px;

    margin-bottom:20px;

    display:flex;

    gap:10px;

    flex-wrap:wrap;
}

.filter-box select{

    padding:8px;

    border:none;

    border-radius:5px;
}

.search-btn{

    background:#4CAF50;

    color:white;

    border:none;

    padding:8px 15px;

    border-radius:5px;

    cursor:pointer;
}

.clear-btn{

    background:#f44336;

    color:white;

    text-decoration:none;

    padding:8px 15px;

    border-radius:5px;
}
.table-wrapper{

    width:100%;

    overflow-x:auto;

    -webkit-overflow-scrolling:touch;
}

table{

    width:100%;

    border-collapse:collapse;

    table-layout:fixed;

    background:
    rgba(255,255,255,0.08);

    backdrop-filter:blur(3px);

    border-radius:15px;
}

th{

    padding:6px;

    background:
    rgba(255,255,255,0.15);

    font-size:13px;

    word-wrap:break-word;
}

td{

    padding:6px;

    text-align:center;

    font-size:12px;

    word-wrap:break-word;

    overflow-wrap:break-word;
}tr:nth-child(even){

    background:
    rgba(255,255,255,0.05);
}

button{

    padding:8px 14px;

    border:none;

    border-radius:5px;

    cursor:pointer;
}
.comment-btn{

    min-width:70px;

    font-size:11px;

    padding:6px;
}

.status-dropdown{

    width:90px;

    font-size:12px;
}

.update-btn{

    font-size:12px;

    padding:6px 10px;
}

.update-btn{

    margin-top:5px;
}
@media screen and (max-width:768px){

    body{
        padding:10px;
    }

    h1{
        font-size:24px;
    }

    .top-buttons{
        flex-direction:column;
    }

    .filter-box{
        flex-direction:column;
    }

    .filter-box select,
    .search-btn,
    .clear-btn{
        width:100%;
    }

    .container{
        overflow-x:auto;
    }

 

</style>

<script>

window.onload = function(){

    const hash =
            window.location.hash;

    if(hash){

        const element =
                document.querySelector(hash);

        if(element){

        	element.scrollIntoView({

        	    behavior:'smooth',

        	    block:'nearest'
        	});        }
    }
};

</script>

</head>

<body>

<div class="container">

<div style="display:flex;
            justify-content:space-between;
            align-items:center;
            margin-bottom:20px;">

    <h1>Admin Dashboard</h1>

    <a href="logout"
       style="background:#dc3545;
              color:white;
              padding:10px 15px;
              text-decoration:none;
              border-radius:5px;
              font-weight:bold;">
        Logout
    </a>

</div>

<div class="top-buttons">
<a href="analytics"
class="analytics-btn">

Analytics Dashboard

</a>

<a href="exportTickets"
class="export-btn">

Download Tickets Report

</a>

</div>

<form action="adminDashboard"
method="get">

<div class="filter-box">

<select name="status">

<option value=""
<%=selectedStatus == null ||
selectedStatus.isEmpty()
? "selected" : ""%>>
All Status
</option>

<option value="OPEN"
<%="OPEN".equals(selectedStatus)
? "selected" : ""%>>
OPEN
</option>

<option value="IN_PROGRESS"
<%="IN_PROGRESS".equals(selectedStatus)
? "selected" : ""%>>
IN_PROGRESS
</option>

<option value="RESOLVED"
<%="RESOLVED".equals(selectedStatus)
? "selected" : ""%>>
RESOLVED
</option>

<option value="CLOSED"
<%="CLOSED".equals(selectedStatus)
? "selected" : ""%>>
CLOSED
</option>

</select>

<select name="priority">

<option value=""
<%=selectedPriority == null ||
selectedPriority.isEmpty()
? "selected" : ""%>>
All Priority
</option>

<option value="HIGH"
<%="HIGH".equals(selectedPriority)
? "selected" : ""%>>
HIGH
</option>

<option value="MEDIUM"
<%="MEDIUM".equals(selectedPriority)
? "selected" : ""%>>
MEDIUM
</option>

<option value="LOW"
<%="LOW".equals(selectedPriority)
? "selected" : ""%>>
LOW
</option>

</select>

<select name="category">

<option value=""
<%=selectedCategory == null ||
selectedCategory.isEmpty()
? "selected" : ""%>>
All Category
</option>

<option value="NETWORK"
<%="NETWORK".equals(selectedCategory)
? "selected" : ""%>>
NETWORK
</option>

<option value="SOFTWARE"
<%="SOFTWARE".equals(selectedCategory)
? "selected" : ""%>>
SOFTWARE
</option>

<option value="HARDWARE"
<%="HARDWARE".equals(selectedCategory)
? "selected" : ""%>>
HARDWARE
</option>

<option value="ACCESS"
<%="ACCESS".equals(selectedCategory)
? "selected" : ""%>>
ACCESS
</option>

</select>

<button
type="submit"
class="search-btn">

Search

</button>

<a href="adminDashboard"
class="clear-btn">

Clear

</a>

</div>

</form>

<div class="table-wrapper">

<table>

<tr>

<th>ID</th>
<th>User ID</th>
<th>Title</th>
<th>Category</th>
<th>Priority</th>
<th>Assigned Team</th>
<th>AI Suggestion</th>
<th>Knowledge Base</th>
<th>Duplicate Check</th>
<th>Escalated</th>
<th>Status</th>
<th>Comments</th>
<th>Last Activity</th>
<th>Update Status</th>
</tr>

<%

List<Ticket> tickets =
(List<Ticket>)request.getAttribute(
"tickets");

if(tickets != null){

for(Ticket ticket : tickets){

%>

<tr id="ticket<%=ticket.getId()%>">

<td><%=ticket.getId()%></td>

<td><%=ticket.getUserId()%></td>

<td><%=ticket.getTitle()%></td>

<td><%=ticket.getCategory()%></td>

<td><%=ticket.getPriority()%></td>

<td><%=ticket.getAssignedTeam()%></td>

<td><%=ticket.getAiSuggestion()%></td>

<td><%=ticket.getKnowledgeBase()%></td>

<td><%=ticket.getDuplicateTicket()%></td>

<td><%=ticket.getEscalated()%></td>

<td>

<%
String statusValue =
ticket.getStatus();

String color = "#2196F3";

if("OPEN".equals(statusValue)){
    color = "#2196F3";
}
else if("IN_PROGRESS".equals(statusValue)){
    color = "#FF9800";
}
else if("RESOLVED".equals(statusValue)){
    color = "#4CAF50";
}
else if("CLOSED".equals(statusValue)){
    color = "#F44336";
}
%>

<span style="
background:<%=color%>;
color:white;
padding:6px 12px;
border-radius:20px;
font-weight:bold;">

<%=statusValue%>

</span>

</td>

<td>

<%
Map<Integer, Boolean> commentMap =
(Map<Integer, Boolean>)
request.getAttribute("commentMap");

boolean hasComments =
commentMap.get(ticket.getId());
%>

<%
Map<Integer, Integer> commentCountMap =
(Map<Integer, Integer>)
request.getAttribute("commentCountMap");

int commentCount =
commentCountMap.get(ticket.getId());
%>

<% if(hasComments){ %>

<a href="viewComments?ticketId=<%=ticket.getId()%>"
class="comment-btn">

Comments (<%=commentCount%>)

</a>

<% } else { %>
<span style="
background:#777;
color:white;
padding:8px 12px;
border-radius:8px;
font-size:14px;
font-weight:bold;
display:inline-block;
min-width:100px;">

No Comments

</span>

<% } %>

</td>
<td>

<%
Map<Integer,String> lastActivityMap =
(Map<Integer,String>)
request.getAttribute(
"lastActivityMap");
%>

<%=lastActivityMap.get(
ticket.getId())%>

</td>
<td>

<form action="updateStatus"
method="post">
<input
type="hidden"
name="ticketId"
value="<%=ticket.getId()%>">

<input
type="hidden"
name="rowId"
value="<%=ticket.getId()%>">

<select
name="status"
class="status-dropdown">

<option value="OPEN"
<%= "OPEN".equals(ticket.getStatus()) ? "selected" : "" %>>
OPEN
</option>

<option value="IN_PROGRESS"
<%= "IN_PROGRESS".equals(ticket.getStatus()) ? "selected" : "" %>>
IN_PROGRESS
</option>

<option value="RESOLVED"
<%= "RESOLVED".equals(ticket.getStatus()) ? "selected" : "" %>>
RESOLVED
</option>

<option value="CLOSED"
<%= "CLOSED".equals(ticket.getStatus()) ? "selected" : "" %>>
CLOSED
</option>

</select>
<br>

<button
type="submit"
class="update-btn">

Update

</button>

</form>

</td>

</tr>

<%
}
}
%>

</table>

</div>

</div>

</body>
</html>