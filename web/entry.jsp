<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2//EN">

<%--
  Created by IntelliJ IDEA.
  src.login.User.User: Meesh
  Date: 10/12/15
  Time: 2:46 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Entry ''</title>
        <link href="stylesheets/css/lists.css" rel="stylesheet" type="text/css"/>
    </head>
        <div id="header">
            <a href="index.jsp">Home</a>
            <a href="<c:url value="/displayLists"/>">Lists</a>
            <a href="submit.jsp">Submit a New Entry</a>
        <%if (request.getRemoteUser() == null) {%>
            <a href="validLogin.jsp">Log In</a>
        <%} else {%>
            <a href="logout.jsp">Log Out</a>
            <a href="persona.jsp">Hi, <%=request.getRemoteUser()%></a>
        <%}%>
        </div>
        <div id="mainContent">
            <c:choose>
                <c:when test="${entry.word}">
                    <c:forEach var="entry" items="${entries}">
                        <table border="1px solid black">
                            <tr>
                                <td>${entry.word}</td>
                                <td>${entry.partOfSpeech}</td>
                                <td>${entry.pronunciation}</td>
                                <td>${entry.pocketDefinition}</td>
                            </tr>
                            <tr>
                                <td>${entry.completeDefinition}</td>
                                <td>${entry.exampleUsage}</td>
                                <td>${entry.variations}</td>
                            </tr>
                            <tr>
                                <td>${entry.etymologyRoots}</td>
                                <td>${entry.submitter}</td>
                                <td>${entry.submittedDate}</td>
                                <td>${entry.voteCount}</td>
                            </tr>
                        </table>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <p>No Data Found</p>
                </c:otherwise>
            </c:choose>
        </div>
    </body>
</html>

