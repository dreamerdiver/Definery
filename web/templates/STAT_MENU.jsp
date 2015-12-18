<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Meesh
  Date: 12/16/15
  Time: 11:51 PM
  To change this template use File | Settings | File Templates.
--%>

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