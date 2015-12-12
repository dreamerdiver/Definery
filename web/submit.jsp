<%--
  Created by IntelliJ IDEA.
  src.login.User.User: Meesh
  Date: 9/28/15
  Time: 7:48 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Submit Entry</title>
        <link href="stylesheets/css/submit.css" rel="stylesheet" type="text/css"/>
        <!--<script type="text/javascript" src="../scripts/reportEntryAttempt.js"></script>-->
    </head>
    <body>
        <div id="menu-wrapper">
            <div id="menu">
                <ul>
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="<c:url value="/displayLists"/>">Lists</a></li>
                    <li><a href="<c:url value="/displayPersona"/>">Hi, <%=request.getRemoteUser()%></a></li>
                    <li><a href="logout.jsp">Log Out</a></li>
                </ul>
            </div>
        </div>
        <div id="content">
            <h3>Write your Entry in the form below</h3>
            <form id="form" name="submitEntry" action="<c:url value="/submitEntry"/>" method="post" autocomplete="off">
                <label for="word">Word: </label>
                    <input type="text" name="word" id="word" maxlength="30" required="required"><br />
                <label for="pos">Part of Speech: </label>
                    <input type="text" name="pos" id="pos" maxlength="10" required="required"><br />
                <label for="pronunciation">Pronunciation: </label>
                    <input type="text" name="pronunciation" id="pronunciation" maxlength="25" required="required"><br />
                <label for="pocket_definition">Pocket Definition: </label>
                    <input type="text" name="pocket_definition" id="pocket_definition" maxlength="20" required="required"><br />
                <label for="complete_definition">Complete Definition: </label>
                    <input type="text" name="complete_definition" id="complete_definition" maxlength="120" required="required"><br />
                <label for="exampleUsage">Usage: </label>
                    <input type="text" name="exampleUsage" id="exampleUsage" maxlength="200" required="required"><br />
                <label for="variations">Variations: </label>
                    <input type="text" name="variations" id="variations" maxlength="100" required="required"><br />
                <label for="etymology_roots">Etymology/ Roots: </label>
                    <input type="text" name="etymology_roots" id="etymology_roots" maxlength="100" required="required"><br /><br />
                <input type="submit" id="submitEntry" value="Submit"><br />
            </form>
            <div id="outputDiv">
                <p>
                    ${submissionMessage}
                </p>
            </div>
        </div>
    </body>
</html>
