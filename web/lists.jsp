<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2//EN">

<%--
  Created by IntelliJ IDEA.
  User: Meesh
  Date: 9/28/15
  Time: 7:50 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
         <title>Lists</title>
         <link href="stylesheets/lists.css" rel="stylesheet" type="text/css"/>
    </head>
        <div id="header">
            <a href="index.jsp">Home</a>
            <a href="submit.jsp">Submit a New Definition</a>
        <%if (request.getRemoteUser() == null) {%>
            <a href="login.jsp">Log In</a>
        <%} else {%>
            <a href="logout.jsp">Log Out</a>
            <a href="persona.jsp">Hi, <%=request.getRemoteUser()%></a>
        <%}%>
        </div>
        <div id="sortByDropdown">
            <form id="form" action="${pageContext.request.contextPath}/displayLists">
                <label for="sortByOptions">Sort By: </label>
                <select id="sortByOptions">
                    <option name="sortParam" value="newest">Newest</option>
                    <option name="sortParam" value="oldest">Oldest</option>
                    <option name="sortParam" value="voteCount">Most Votes</option>
                    <option name="sortParam" value="alphabetical">Alphabetical</option>
                </select>
                <input type="submit" id="sortBy" value="Go">
            </form>
        </div>
        <div id="content">
            <c:choose>
                <c:when test="${entries.size() > 0}">
                    <p>Found Entries: </p>
                    <table border="1px solid black">
                        <c:forEach var="entry" items="${entries}">
                            <tr>
                                <td>${entry.word}</td>
                                <td colspan="2">${entry.pocketDefinition}</td>
                            </tr>
                            <tr>
                                <td>${entry.voteCount}</td>
                                <td>${entry.submitter}</td>
                                <td>${entry.submittedDate}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:when>
                <c:otherwise>
                    <p>No Entries Found</p>
                </c:otherwise>
            </c:choose>
        </div>
    </body>
</html>


