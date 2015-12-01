<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2//EN">

<%--
  Created by IntelliJ IDEA.
  src.login.User.User: Meesh
  Date: 9/28/15
  Time: 7:50 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Lists</title>
        <link href="stylesheets/css/lists.css" rel="stylesheet" type="text/css"/>
        <link href="WEB-INF/scripts/submitVote.js">
    </head>
    <body>
        <div id="menu-wrapper">
            <div id="menu">
                <ul>
                    <li><a href="index.jsp">Home</a></li>
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
        <div id="header-wrapper">
            <div id="header">
                <div id="sortByDropdown">
                    <form id="form" action="<c:url value="/displayLists"/>">
                        <label for="sortByOptions">Sort By: </label>
                        <select id="sortByOptions" name="sortByOptions">
                            <option name="sortParam" value="alphabetical">Alphabetical</option>
                            <option name="sortParam" value="newest">Newest</option>
                            <option name="sortParam" value="oldest">Oldest</option>
                            <option name="sortParam" value="voteCount">Most Votes</option>
                        </select>
                        <input type="submit" id="sortBy" value="Go">
                    </form>
                </div>
            </div>
        </div>
        <div id="content">
        <c:choose>
            <c:when test="${entries.size() != null}">
                <c:forEach var="entry" items="${entries}">
                    <c:url value="/displayEntry" var="servletURL">
                        <c:param name="entryLabel" value="${entry.word}"/>
                    </c:url>
                    <div class="voteHitbox" onclick="init()">
                        <div id="voteCount">
                            ${entry.voteCount}
                        </div>
                    </div>
                    <div class="post">
                        <h2 class="title"><a href="${servletURL}">${entry.word}</a></h2>
                        <div class="entry">
                            <p class="def">${entry.completeDefinition}</p>
                            <p class="date">Entered: ${entry.submittedDate}</p>
                        </div>
                    </div>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <p id="noEntryError">No Entries Found</p>
            </c:otherwise>
        </c:choose>
        </div>
    </body>
    <script>
        init();
    </script>
</html>


