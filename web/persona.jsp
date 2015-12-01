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
        <div id="menu">
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="submit.jsp">Submit a New Entry</a></li>
                <li><a href="<c:url value="/displayLists"/>">Lists</a></li>
                <!--<li><a href="#">Votes</a></li>-->
                <li><a href="logout.jsp">Log Out</a></li>
            </ul>
        </div>
        <div id="content">
            <div class="user">
                <h3>Welcome, <%=request.getRemoteUser()%></h3>
            </div>
            <div class="submittedLinks">
                <p>My Submitted Entries</p>
                <c:choose>
                    <c:when test="${entries.size() != null}">
                        <div id="tableContent">
                            <c:forEach var="entry" items="${entries}">
                                <div class="post">
                                    <div>
                                        <h2 class="title"><strong><a href="#">${entry.word}</a></strong></h2>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <p id="noEntryError">No Entries Found</p>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </body>
</html>
