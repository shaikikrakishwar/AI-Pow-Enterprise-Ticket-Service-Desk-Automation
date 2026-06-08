<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<link rel="icon" type="image/png"
href="images/favicon.png">
<link rel="stylesheet"
href="css/style.css">
<meta charset="UTF-8">
<title>Login</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial,sans-serif;
}

body{
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;

    background:linear-gradient(
        135deg,
        #233329,
        #3b5d50,
        #1f4037
    );
}

.container{

    width:400px;

    padding:30px;

    border-radius:20px;

    background:rgba(255,255,255,0.1);

    backdrop-filter:blur(3px);

    box-shadow:0 8px 32px rgba(0,0,0,0.3);
}

.success{

    background:#27ae60;

    color:white;

    padding:12px;

    border-radius:10px;

    margin-bottom:15px;

    text-align:center;

    font-weight:bold;
}

.error{

    background:#e74c3c;

    color:white;

    padding:12px;

    border-radius:10px;

    margin-bottom:15px;

    text-align:center;

    font-weight:bold;
}

h2{
    color:white;
    text-align:center;
    margin-bottom:20px;
}

input{

    width:100%;

    padding:12px;

    margin-top:10px;

    border:none;

    border-radius:10px;
}

button{

    width:100%;

    margin-top:20px;

    padding:12px;

    border:none;

    border-radius:10px;

    cursor:pointer;

    font-weight:bold;
}

a{
    color:white;
}

p{
    text-align:center;
    margin-top:15px;
}

</style>

</head>

<body>

<div class="container">

<%
String success =
request.getParameter("success");

String error =
request.getParameter("error");
%>

<%
if("register".equals(success)){
%>

<div class="success">

✓ Registration Successful. Please Login.

</div>

<%
}
%>

<%
if("login".equals(error)){
%>

<div class="error">

✗ Invalid Email or Password

</div>

<%
}
%>

<h2>Login</h2>

<form action="login" method="post">

<input
type="email"
name="email"
placeholder="Enter Email"
required>

<input
type="password"
name="password"
placeholder="Enter Password"
required>

<button type="submit">

Login

</button>

</form>

<p>

<a href="register.jsp">

Create Account

</a>

</p>

</div>

</body>
</html>