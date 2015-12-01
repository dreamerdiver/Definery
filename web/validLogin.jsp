<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  src.login.User.User: Meesh
  Date: 10/14/15
  Time: 9:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Definery - Welcome</title>
    <link href="stylesheets/css/validLogin.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <div id="header"></div>
    <div id="mainContent">
        <h2>Thank You, and Welcome to Definery</h2>
        <a href="<c:url value="/displayLists"/>">Lists</a>
        <a href="<c:url value="/displayPersona"/>">Hi, <%request.getRemoteUser();%></a>
        <a href="logout.jsp">Log Out</a>
    </div>
</body>
</html>
