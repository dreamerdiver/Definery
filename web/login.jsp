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
        <div id="menu-wrapper">
            <div id="menu">
                <ul>
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="<c:url value="/displayLists"/>">Lists</a></li>
                </ul>
            </div>
        </div>
        <div id="content">
            <h2 id="login">Login or create an account</h2>
            <form id="form" action="j_security_check" method="post" >
                <label for="j_username">Username: </label>
                    <input type="text" name="j_username" id="j_username"><br />
                <label for="j_password">Password: </label>
                    <input type="password" name="j_password" id="j_password"><br />
                <input id="submit" type="submit" value="Submit Login"><br />
            </form>
        </div>
    </body>
</html>