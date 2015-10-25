<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2//EN">

<%--
  Created by IntelliJ IDEA.
  src.project.User: Meesh
  Date: 10/12/15
  Time: 2:46 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Entry ''</title>
        <link href="stylesheets/lists.css" rel="stylesheet" type="text/css"/>
    </head>
        <div id="header">
            <a href="index.jsp">Home</a>
            <a href="submit.jsp">Submit a New Definition</a>
        <%if (request.getRemoteUser() == null) {%>
            <a href="validLogin.jsp">Log In</a>
        <%} else {%>
            <a href="logout.jsp">Log Out</a>
            <a href="persona.jsp">Hi, <%=request.getRemoteUser()%></a>
        <%}%>
        </div>
        <div id="content">
            <h1>these are the lists. login to submit</h1>
            <c:choose>
                <c:when test="${entries.size() > 0}">
                    <p>Found Employees: </p>
                    <table border="1px solid black">
                        <c:forEach var="entry" items="${entries}">
                            <tr>
                                <td>${entry.word}</td>
                                <td>${entry.partOfSpeech}</td>
                                <td>${entry.pronunciation}</td>
                                <td>${entry.pocketDefinition}</td>
                                <td>${entry.completeDefinition}</td>
                                <td>${entry.exampleUsage}</td>
                                <td>${entry.variations}</td>
                                <td>${entry.etymologyRoots}</td>
                                <td>${entry.submitter}</td>
                                <td>${entry.submittedDate}</td>
                                <td>${entry.voteCount}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:when>
                <c:otherwise>
                    <p>No Employees Found</p>
                </c:otherwise>
            </c:choose>
        </div>
    </body>
</html>

