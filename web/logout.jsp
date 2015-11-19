<%--
  Created by IntelliJ IDEA.
  src.login.User.User: Meesh
  Date: 10/3/15
  Time: 10:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true"%>
<html>
    <head>
        <title>User '<%=request.getRemoteUser()%>' has been logged out.</title>
        <link href="stylesheets/css/logout.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="header">
            <% session.invalidate(); %>
        </div>
        <div id="mainContent">
            <h3>User '<%=request.getRemoteUser()%>' has been logged out.</h3>
            <a href="index.jsp">Return to Home</a>
        </div>
    </body>
</html>
