<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  src.login.User.User: Meesh
  Date: 9/28/15
  Time: 7:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Login/ Create Account</title>
        <link href="stylesheets/css/login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="header">
            <a href="index.jsp">Home</a>
            <a href="<c:url value="/displayLists"/>">Lists</a>
        </div>
        <div id="mainContent">
            <h3>Login or create an account</h3>
            <form action="j_security_check" method="post" >
                <label for="j_username">Username: </label>
                    <input type="text" name="j_username" id="j_username"><br />
                <label for="j_password">Password: </label>
                    <input type="password" name="j_password" id="j_password"><br />
                <input type="submit" value="Submit Login"><br />
            </form>
        </div>
  </body>
</html>
