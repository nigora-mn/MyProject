<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: m-mur
  Date: 11-Apr-21
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome page</title>
</head>
<body>
<h3>Information for all Employees</h3>
<br><br>
<security:authorize access="hasRole('HR')">
<input type="button" value="Salary"
    onclick="window.location.href='hr_info'">
Only for HR staff
</security:authorize>
<br><br>
<security:authorize access="hasRole('MANAGER')">
<input type="button" value="Performance"
       onclick="window.location.href='manager_info'">
Only for Managers
</security:authorize>
</body>
</html>
