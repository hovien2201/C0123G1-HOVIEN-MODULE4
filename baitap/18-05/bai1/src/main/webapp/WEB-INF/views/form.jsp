<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 05/18/23
  Time: 10:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .container{
            margin-left: 35%;
            margin-right: 35%;
            margin-top: 15%;
            padding: 40px;
            border: 1px solid black;
        }
        input{
            margin-bottom: 15px;
        }
    </style>
</head>
<body>
<div class="container">
<h1 style="text-align: center">Chuyển đổi USD sang VND</h1>
<form action="/" method="post">
    <lable>Nhập USD:</lable>
    <input type="number" name="usd" placeholder="USD">
    <br>
    <lable>Tỉ giá:</lable>
    <input type="number" name="tigia" style="margin-left: 30px">
    <br>
    <button type="submit">Tính Toán</button>
</form>
<h1>Kết quả: ${vnd} VND</h1>
</div>
</body>
</html>
