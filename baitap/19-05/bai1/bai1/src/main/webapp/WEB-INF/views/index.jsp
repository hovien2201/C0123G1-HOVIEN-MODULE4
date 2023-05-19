<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<style>
    .container {
        margin-left: 35% ;
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
        <input type="checkbox" value="Lettuce" name="lettuce">Lettuce
        <input type="checkbox" value="Tomato" name="tomato">Tomato
        <input type="checkbox" value="Mustard" name="mustard">Mustard
        <input type="checkbox" value="Sprouts" name="sprouts">Sprouts
        <br>
        <button type="submit">submit</button>
    </form>
    <h3>Selected seasoning list:${lettuce} ${tomato} ${mustard} ${sprouts}</h3>
</div>
</body>
</html>