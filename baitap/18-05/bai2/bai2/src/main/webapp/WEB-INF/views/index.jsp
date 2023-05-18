<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 05/18/23
  Time: 1:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        label{
            margin-top: 30px;
        }
        .container{
            margin-left: 35%;
            margin-right: 35%;
            margin-top: 15%;
            padding: 40px;
            border: 1px solid black;
        }
    </style>
</head>
<body>
<div class="container">
    <h1 style="text-align:center">Translate</h1>
    <form action="/tra" method="post">
        <lable>English</lable>
        <input name="english" placeholder="English" style="margin-left: 60px" value="${english}">
        <br>
        <div style="display: flex" >
        <lable style="padding-top: 27px;margin-right: 20px">Vietnamese:</lable>
        <h4 style="font-size: 20px">${vietnamese}</h4>
        </div>
        <br>
        <button type="submit" style="font-size: 30px">Search</button>
    </form>
</div>
</body>
</html>
