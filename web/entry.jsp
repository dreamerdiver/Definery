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
        <c:import url="/templates/STAT_MENU.jsp" />
        <div id="content">
            <c:choose>
                <c:when test="${entries.size() != null}">
                    <div id="tableContent">
                        <c:forEach var="entry" items="${entries}">
                            <c:url value="/sendVoteRequest" var="voteServlet">
                                <c:param name="entryLabel" value="${entry.word}"/>
                            </c:url>
                            <button id="voteHitbox" class="voteHitbox">
                                <p id="voteCount">${entry.voteCount}</p>
                            </button>
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

