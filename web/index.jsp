<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  src.login.User.User: Meesh
  Date: 9/23/15
  Time: 7:25 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Definery</title>
        <link href="stylesheets/css/index.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="header">
            <h1>~Definery~</h1>
        </div>
        <div id="mainContent">
            <a href="submit.jsp">Submit a New Entry</a>
            <a href="<c:url value="/displayLists"/>">Lists</a>
        <%if (request.getRemoteUser() == null) {%>
            <a href="validLogin.jsp">Log In</a>
        <%} else {%>
            <a href="persona.jsp">Hi, <%=request.getRemoteUser()%></a>
            <a href="logout.jsp">Log Out</a>
        <%}%>
        </div>
    </body>
</html>
