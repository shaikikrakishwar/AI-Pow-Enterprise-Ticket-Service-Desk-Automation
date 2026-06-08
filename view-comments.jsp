<%@ page import="java.util.List" %>
<%@ page import="com.project.model.TicketComment" %>
<%@ page import="com.project.model.User" %>
<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Ticket Comments</title>

<link rel="icon"
      type="image/png"
      href="images/favicon.png">
      
      <link rel="stylesheet"
href="css/style.css">

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

    width:80%;

    margin:auto;
}

h1{

    text-align:center;

    margin-bottom:25px;
}

.backBtn{

    display:inline-block;

    background:white;

    color:black;

    padding:12px 25px;

    border-radius:10px;

    text-decoration:none;

    font-weight:bold;

    font-size:16px;

    transition:0.3s;
}

.backBtn:hover{

    background:#f1f1f1;

    transform:translateY(-2px);
}
.comment-card{

    background:
    rgba(255,255,255,0.1);

    padding:15px;

    border-radius:10px;

    margin-bottom:15px;

    backdrop-filter:blur(3px);
}

.user{

    font-weight:bold;

    color:#FFD700;
}

.date{

    font-size:12px;

    opacity:0.8;

    margin-top:5px;
}

textarea{

    width:100%;

    height:140px;

    padding:10px;

    border:none;

    border-radius:10px;

    margin-top:15px;

    resize:none;
}

button{

    margin-top:15px;

    padding:12px 25px;

    border:none;

    border-radius:10px;

    background:#4CAF50;

    color:white;

    cursor:pointer;

    font-weight:bold;

    font-size:15px;

    transition:0.3s;
}

button:hover{

    background:#43a047;
}
</style>

</head>

<body>

<div class="container">
<%
User user =
(User) session.getAttribute("user");
%>

<%
if(user != null &&
   "ADMIN".equalsIgnoreCase(user.getRole())){
%>

<a href="adminDashboard"
class="backBtn">
Back To Admin Dashboard
</a>

<%
}else{
%>

<a href="dashboard"
class="backBtn">
Back To Dashboard
</a>

<%
}
%>

<br><br>

<h1>

Ticket Discussion

</h1>

<%

List<TicketComment> comments =
(List<TicketComment>)
request.getAttribute(
"comments");

if(comments != null &&
!comments.isEmpty()) {

for(TicketComment comment :
comments) {

%>

<div class="comment-card">

<div class="user">

<%=comment.getUserName()%>

</div>

<br>

<div>

<%=comment.getCommentText()%>

</div>

<div class="date">

<%=comment.getCommentDate()%>

</div>

</div>

<%
}
}
else{
%>

<div class="comment-card">

No comments yet.

</div>

<%
}
%>

<form action="addComment"
      method="post">

<input
type="hidden"
name="ticketId"
value="<%=request.getAttribute("ticketId")%>">

<textarea
name="commentText"
placeholder="Write your comment here..."
required>

</textarea>

<button type="submit">

Add Comment

</button>

</form>

</div>

</body>

</html>