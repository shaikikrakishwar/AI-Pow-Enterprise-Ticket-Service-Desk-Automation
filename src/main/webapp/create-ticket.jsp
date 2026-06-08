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

<title>Create Ticket</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Segoe UI',sans-serif;
}

body{

    min-height:100vh;

    display:flex;
    justify-content:center;
    align-items:center;

    background:linear-gradient(
        135deg,
        #1f4037,
        #3b5d50,
        #233329
    );
}

.backBtn{

    position:absolute;

    top:30px;
    left:30px;

    background:white;

    padding:10px 15px;

    border-radius:10px;

    text-decoration:none;

    color:black;

    font-weight:bold;
}

.container{

    width:600px;

    padding:40px;

    border-radius:20px;

    background:rgba(255,255,255,0.08);

    backdrop-filter:blur(3px);
}

h1{

    color:white;

    text-align:center;

    margin-bottom:30px;
}

input,
textarea{

    width:100%;

    padding:15px;

    border:none;

    border-radius:12px;

    margin-top:15px;
}

button{

    width:100%;

    margin-top:25px;

    padding:15px;

    border:none;

    border-radius:12px;

    background:white;

    font-weight:bold;

    cursor:pointer;
}

</style>

</head>

<body>

<a href="dashboard"
class="backBtn">

Back to Dashboard

</a>

<div class="container">

<h1>Create Ticket</h1>

<form action="createTicket"
method="post">

<input
type="text"
name="title"
placeholder="Ticket Title"
required>

<textarea
name="description"
rows="6"
placeholder="Describe your issue"
required></textarea>

<button type="submit">

Create Ticket

</button>

</form>

</div>

</body>
</html>