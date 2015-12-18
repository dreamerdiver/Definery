
<%--
Created by IntelliJ IDEA.
src.login.User.User: Meesh
Date: 9/28/15
Time: 7:50 PM
To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>Lists</title>
<link href="stylesheets/css/lists.css" rel="stylesheet" type="text/css"/>
<!--<script type="text/javascript" src="../scripts/submitVote.js"/>"></script>-->
<!--<script type="text/javascript" src="../scripts/reportEntryAttempt.js"></script>-->
<body>
    <c:import url="/templates/DYN_MENU.jsp" />
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
                <c:url value="/displayEntry" var="entryServlet">
                    <c:param name="entryLabel" value="${entry.word}"/>
                </c:url>
                <c:url value="/sendVoteRequest" var="voteServlet">
                    <c:param name="entryLabel" value="${entry.word}"/>
                </c:url>
                <form id="voteHitbox" class="voteHitbox">
                <%if (request.getRemoteUser() != null) {%>
                    <a href="${voteServlet}" id="voteCount">${entry.voteCount}</a>
                <%} else {%>
                    <h3 id="voteCount">${entry.voteCount}</h3>
                <%}%>
                </form>
                <div id="entry">
                    <table class="post">
                        <tr>
                            <td>
                                <h2 class="title"><a href="${entryServlet}">${entry.word}</a></h2>
                            </td>
                            <td>
                                <p class="date">${entry.submittedDate}</p>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <p class="def">${entry.completeDefinition}</p>
                            </td>
                        </tr>
                    </table>
                </div>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <p id="noEntryError">No Entries Found</p>
        </c:otherwise>
    </c:choose>
    </div>
</body>



