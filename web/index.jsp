<%--
  Created by IntelliJ IDEA.
  User: Meesh
  Date: 9/23/15
  Time: 7:25 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Definery</title>
        <link href="stylesheets/index.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="header">
            <h1>~Definery~</h1>
        </div>
        <div id="content">
            <a href="submit.jsp">Submit a New Definition</a>
            <a href="lists.jsp">Lists</a>
        <%if (request.getRemoteUser() == null) {%>
            <a href="validLogin.jsp">Log In</a>
        <%} else {%>
            <a href="persona.jsp">Persona</a>
            <a href="logout.jsp">Log Out</a>
        <%}%>
        </div>
    </body>
</html>
