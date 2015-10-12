<%--
  Created by IntelliJ IDEA.
  User: Meesh
  Date: 9/29/15
  Time: 3:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>'<%=request.getRemoteUser()%>' Persona</title>
        <link href="stylesheets/persona.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="header">
            <a href="index.jsp">Home</a>
            <a href="submit.jsp">Submit a New Definition</a>
            <a href="lists.jsp">Lists</a>
            <a href="#">Submissions</a>
            <a href="#">Votes</a>
            <a href="logout.jsp">Log Out</a>
        </div>
        <div id="content">
            <h3>this is the user account page. logged in as '<%=request.getRemoteUser()%>'</h3>
        </div>
    </body>
</html>
