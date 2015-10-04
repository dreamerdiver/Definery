<%--
  Created by IntelliJ IDEA.
  User: Meesh
  Date: 10/3/15
  Time: 10:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true"%>
<html>
    <head>
        <title>User '<%=request.getRemoteUser()%>' has been logged out.</title>
        <link href="stylesheets/logout.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>User '<%=request.getRemoteUser()%>' has been logged out.</h1>
        <% session.invalidate(); %><br/><br/>
        <a href="index.jsp">Return to Home</a>
    </body>
</html>
