<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
</head>
<style>
    .container{
        margin-top: 15%;
        margin-left: 30%;
        margin-right: 35%;
        padding: 10px;
        border: 1px solid black;
        text-align: center;
    }
</style>
<body>
<div class="container">
<h1 >Calculator</h1>
<form action="/calculate" method="post">
    <input name="number1" type="number" value="${number1}">
    <input name="number2" type="number" value="${number2}">
    <br>
    <br>
    <button type="submit" name="calculation" value="+">Addition(+)</button>
    <button type="submit" name="calculation" value="-">Subtraction(-)</button>
    <button type="submit" name="calculation" value="x">Multiplication(x)</button>
    <button type="submit" name="calculation" value="/">Division(/)</button>
</form>
<h3>Result: ${result}</h3>
</div>
</body>
</html>