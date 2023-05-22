<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 05/22/23
  Time: 10:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Settings</h1>
<form:form action="/edit" method="post" modelAttribute="setting">
    <label>Languages</label>
    <form:input path="languages"/>
    <lable>Page size</lable>
    <form:input path="pageSize" />
    <lable>Spams filter</lable>
    <form:input path="spamsFilter"/>
    <lable>Signature</lable>
    <form:input path="signature"/>
</form:form>
</body>
</html>
