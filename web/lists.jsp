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
         <link href="stylesheets/lists.css" rel="stylesheet" type="text/css"/>
    </head>
        <div id="header">
            <a href="index.jsp">Home</a>
            <a href="submit.jsp">Submit</a>
        <%if (request.getRemoteUser() == null) {%>
            <a href="validLogin.jsp">Log In</a>
        <%} else {%>
            <a href="logout.jsp">Log Out</a>
            <a href="persona.jsp">Hi, <%=request.getRemoteUser()%></a>
        <%}%>
        </div>
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
        <div id="mainContent">
            <c:choose>
                <c:when test="${entries.size() != null}">
                    <div id="tableContent">
                        <c:forEach var="entry" items="${entries}">
                            <a href="entry.jsp#${entry.word}">
                                <table id="entryTable${entry.word}" border="1px solid black">
                                    <tr>
                                        <td id="voteCount" onclick="" rowspan="3">${entry.voteCount}</td>
                                    </tr>
                                    <tr>
                                        <td id="word" rowspan="2">${entry.word}</td>
                                        <td id="pos" rowspan="1">${entry.partOfSpeech}</td>
                                        <td id="submittedDate">${entry.submittedDate}</td>
                                    </tr>
                                    <tr>
                                        <td id="pocketDefinition" colspan="2">${entry.pocketDefinition}</td>
                                    </tr>
                                </table>
                            </a>
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


