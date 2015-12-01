<%--
  Created by IntelliJ IDEA.
  src.login.User.User: Meesh
  Date: 10/2/15
  Time: 10:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Admin</title>
        <link href="stylesheets/css/admin.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="header">
            <a href="index.jsp">Home</a>
            <a href="submit.jsp">Submit a New Entry</a>
            <a href="<c:url value="/displayLists"/>">Lists</a>
            <!--<a href="#">Votes</a>-->
            <a href="logout.jsp">Log Out</a>
            <h1>stats and secret things</h1>
        </div>
        <div id="mainContent">
            <h1>stats and secret things</h1>
            <h3>logged in as '<%=request.getRemoteUser()%>'</h3>
        </div>
    </body>
</html>
