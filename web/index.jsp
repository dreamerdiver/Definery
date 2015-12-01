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
        <div id="content-wrapper">
            <div id="content">
                <h2><strong>Definery.</strong></h2>
                <span id="menu">
                    <ul>
                        <li><a href="<c:url value="/displayLists"/>">Lists</a></li>
                        <li><a href="submit.jsp">Submit a New Entry</a></li>
                        <%if (request.getRemoteUser() == null) {%>
                        <li><a href="validLogin.jsp">Log In</a></li>
                        <%} else {%>
                        <li><a href="<c:url value="/displayPersona"/>">Hi, <%=request.getRemoteUser()%></a></li>
                        <li><a href="logout.jsp">Log Out</a></li>
                        <%}%>
                    </ul>
                </span>
            </div>
        </div>
    </body>
</html>
