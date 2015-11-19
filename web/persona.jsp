<%--
  Created by IntelliJ IDEA.
  src.login.User.User: Meesh
  Date: 9/29/15
  Time: 3:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>'<%=request.getRemoteUser()%>' Persona</title>
        <link href="stylesheets/css/persona.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="header">
            <a href="index.jsp">Home</a>
            <a href="submit.jsp">Submit a New Entry</a>
            <a href="<c:url value="/displayLists"/>">Lists</a>
            <a href="#">Submissions</a>
            <a href="#">Votes</a>
            <a href="logout.jsp">Log Out</a>
        </div>
        <div id="mainContent">
            <h3>Welcome, <%=request.getRemoteUser()%></h3>
        </div>
    </body>
</html>
