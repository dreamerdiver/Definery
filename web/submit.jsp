<%--
  Created by IntelliJ IDEA.
  User: Meesh
  Date: 9/28/15
  Time: 7:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Submit Entry</title>
        <link href="stylesheets/submit.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="header">
            <a href="index.jsp">Home</a>
            <a href="lists.jsp">View Lists</a>
            <a href="account.jsp">Account</a>
            <a href="logout.jsp">Log Out</a>
        </div>
        <div id="content">
            <h3>Write your Entry in the form below</h3>
            <form id="form" name="employeeAdd"
                  action="${pageContext.request.contextPath}/addEntry"
                  method="post">
                <label for="word">Word: </label>
                    <input type="text" name="word" id="word" maxlength="30"><br />
                <label for="pos">Part of Speech: </label>
                    <input type="text" name="pos" id="pos" maxlength="10"><br />
                <label for="pronunciation">Pronunciation: </label>
                    <input type="text" name="pronunciation" id="pronunciation" maxlength="25"><br />
                <label for="pocket_definition">Pocket Definition: </label>
                    <input type="text" name="pocket_definition" id="pocket_definition" maxlength="20"><br />
                <label for="complete_definition">Complete Definition: </label>
                    <input type="text" name="complete_definition" id="complete_definition" maxlength="120"><br />
                <label for="usage">Usage: </label>
                    <input type="text" name="usage" id="usage" maxlength="200"><br />
                <label for="variations">Variations: </label>
                    <input type="text" name="variations" id="variations" maxlength="100"><br />
                <label for="etymology_roots">Etymology/ Roots: </label>
                    <input type="text" name="etymology_roots"
                           id="etymology_roots" maxlength="100"><br /><br />
                <h3>
                    ${submissionMessage}
                </h3><br />
                <input type="submit"><br />
            </form>
        </div>

    </body>
</html>
