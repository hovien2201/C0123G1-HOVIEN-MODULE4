<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<style>
    .container {
        margin-left: 35%;
        margin-top: 20%;
        margin-right: 40%;
        border: 1px solid black;
        text-align: center;
    }

    input {
        margin: 10px;
    }
</style>
<body>
<div class="container">
    <h1>Sandwich Condiments</h1>
    <form action="/save" method="post">
        <input type="checkbox" value="Lettuce" name="spice">Lettuce
        <input type="checkbox" value="Tomato" name="spice">Tomato
        <input type="checkbox" value="Mustard" name="spice">Mustard
        <input type="checkbox" value="Sprouts" name="spice">Sprouts
        <br>
        <button type="submit">submit</button>
    </form>
    <h3>Selected seasoning list:</h3>
    <c:forEach var="spice" items="${spice}"><span>${spice} </span></c:forEach>


</div>
</body>
</html>