<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        form{
            height: 270px;
            margin: 10px;
        }
        .div{
            margin-left: 40%;
            margin-top: 10%;
            margin-right: 40%;
            border: 1px solid black;
            height: 400px;
        }
    </style>
</head>
<body>
<div  class="div">
    <h1 style="text-align: center">Settings</h1>
<form:form action="/update" method="post" modelAttribute="settings">
    <div >
        <label>Languages</label>
        <form:select path="languages"  cssStyle="height: 30px;width: 200px;margin-left: 26px;">
            <form:option value="English">English</form:option>
            <form:option value="Vietnamese">Vietnamese </form:option>
            <form:option value="Japanese">Japanese</form:option>
            <form:option value="Chinese">Chinese </form:option>
        </form:select>

    </div>
    <div style="  margin-top: 20px;">
        <label>Page Size </label>
        <span style="margin-left: 33px">Show</span>
        <form:select path="pageSize" cssStyle="margin-left: 10px;">
            <form:option value="5">5</form:option>
            <form:option value="10">10</form:option>
            <form:option value="15">15</form:option>
            <form:option value="20">20</form:option>
            <form:option value="25">25</form:option>
            <form:option value="50">50</form:option>
            <form:option value="100">100</form:option>
        </form:select>
        <label> emails her page</label>
    </div>
    <div style="margin-top: 20px;">
        <label>Spams filter </label>
        <form:checkbox path="spamsFilter" cssStyle="  margin-left: 17px;"/>Enable spams filter
    </div>

    <div style="margin-top: 20px">
        <label>Signature</label>
        <form:textarea  type="text" name="signature" path="signature" cssStyle=" margin-left: 30px; width: 200px; height: 59px;"/>
    </div>
    <button style="margin-left : 120px;margin-top: 20px" type="submit">Update</button>
</form:form>
<button type="submit" onclick="window.location.href='/'" style="margin-left: 130px">Cancel</button>
</div>
</body>
</html>