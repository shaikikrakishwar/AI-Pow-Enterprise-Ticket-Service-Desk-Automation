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
<title>Register</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial, sans-serif;
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

h2{
    color:white;
    text-align:center;
    margin-bottom:20px;
}

input,select{

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

    background:white;

    cursor:pointer;

    font-weight:bold;
}

p{
    text-align:center;
    margin-top:15px;
}

a{
    color:white;
}

</style>

</head>

<body>

<div class="container">

    <h2>Employee Registration</h2>

    <form action="register" method="post">

        <input
            type="text"
            name="name"
            placeholder="Enter Name"
            required>

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

        <select name="department">

            <option value="IT">IT</option>

            <option value="HR">HR</option>

            <option value="Finance">Finance</option>

            <option value="Sales">Sales</option>

            <option value="Operations">Operations</option>

        </select>

        <button type="submit">

            Register

        </button>

    </form>

    <p>

        <a href="login.jsp">

            Already have an account?

        </a>

    </p>

</div>

</body>
</html>