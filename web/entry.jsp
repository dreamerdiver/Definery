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
        <title>Entry </title>
        <link href="stylesheets/css/entry.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="menu-wrapper">
            <div id="menu">
                <ul>
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="<c:url value="/displayLists"/>">Lists</a></li>
                    <li><a href="submit.jsp">Submit</a></li>
                    <%if (request.getRemoteUser() == null) {%>
                    <li><a href="validLogin.jsp">Log In</a></li>
                    <%} else {%>
                    <li><a href="logout.jsp">Log Out</a></li>
                    <li><a href="<c:url value="/displayPersona"/>">Hi, <%=request.getRemoteUser()%></a></li>
                    <%}%>
                </ul>
            </div>
        </div>
        <div id="content">
            <c:choose>
                <c:when test="${entries.size() != null}">
                    <div id="tableContent">
                        <c:forEach var="entry" items="${entries}">
                            <div class="voteHitbox" onclick="init()">
                                <div id="voteCount">
                                        ${entry.voteCount}
                                </div>
                            </div>
                            <div class="post">
                                <div>
                                    <h2 class="title"><strong><a href="#">${entry.word}</a></strong></h2>
                                </div>
                                <div class="entry">
                                    <p class="subInfo">
                                        <span>${entry.partOfSpeech}</span>
                                        <span>${entry.pronunciation}</span>
                                    </p>
                                <br><br>
                                    <p class="info">
                                        <span id="completeDefinition">${entry.completeDefinition}</span>
                                <br><br>
                                        <span id="exampleUsage">${entry.exampleUsage}</span>
                                <br><br>
                                        <span id="variations">${entry.variations}</span>
                                        <span id="etymologyRoots">${entry.etymologyRoots}</span>
                                        <span id="pocketDefinition" >${entry.pocketDefinition}</span>
                                    </p>
                                    <p class="meta">
                                        <span class="date">Entered: ${entry.submittedDate}</span>
                                        <span class="posted">Posted by ${entry.submitter}</span>
                                    </p>
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
    </body>
</html>

