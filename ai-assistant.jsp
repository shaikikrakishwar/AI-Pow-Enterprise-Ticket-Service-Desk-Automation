<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<link rel="icon" type="image/png"
href="images/favicon.png">
<link rel="stylesheet"
href="css/style.css">

<title>AI Assistant</title>

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

    width:700px;

    margin:auto;

    background:rgba(255,255,255,0.08);

    padding:25px;

    border-radius:20px;
}

.backBtn{

    background:white;

    padding:10px 15px;

    border-radius:10px;

    text-decoration:none;

    color:black;

    font-weight:bold;
}

h2{

    margin-top:20px;

    margin-bottom:20px;
}

textarea{

    width:100%;

    padding:12px;

    border-radius:10px;

    margin-top:15px;
}

button{

    margin-top:15px;

    padding:10px 20px;

    border:none;

    border-radius:10px;

    cursor:pointer;

    font-weight:bold;
}

.response{

    margin-top:20px;

    padding:15px;

    background:rgba(255,255,255,0.1);

    border-radius:10px;
}

</style>

</head>

<body>

<div class="container">

<a href="employee-dashboard.jsp"
class="backBtn">

← Back to Dashboard

</a>

<h2>AI Help Desk Assistant</h2>

<form method="post">

<textarea
name="question"
rows="5"
placeholder="Ask a question..."
required></textarea>

<button type="submit">

Ask AI

</button>

</form>

<%

String question =
request.getParameter("question");

if(question != null){

String answer =
"Please create a support ticket for this issue.";

if(question.toLowerCase()
.contains("password")){

answer =
"Use Forgot Password and reset your credentials.";
}

else if(question.toLowerCase()
.contains("printer")){

answer =
"Check printer power and cable connection.";
}

else if(question.toLowerCase()
.contains("wifi")){

answer =
"Restart router and verify network settings.";
}

%>

<div class="response">

<b>Your Question:</b>

<br><br>

<%=question%>

<br><br>

<b>AI Suggestion:</b>

<br><br>

<%=answer%>

</div>

<%
}
%>

</div>

</body>
</html>