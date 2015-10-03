<%--
  Created by IntelliJ IDEA.
  User: Meesh
  Date: 9/28/15
  Time: 7:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login/ Create Account</title>
</head>
  <body>

      <form action="j_security_check" method="post">
        <h1>Login or create an account</h1>
        <input type="text" name="j_username"><br />
        <input type="password" name="j_password"><br />
        <input type="submit"><br />
        <a href="index.jsp">Home</a>
      </form>
  </body>
</html>
