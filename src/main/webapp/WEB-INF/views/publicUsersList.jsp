<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: riffraff
  Date: 05.06.19
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Public Users List</title>
    <script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    <link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
</head>
<body>
<div class="container white-background">
    <%@include file="/WEB-INF/views/header.jspf" %>
    <div class="row white-form">
        <form:form class="form-inline my-2 my-lg-0" method="post">
            <input name="search" class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form:form>
    </div>
    <table class="table table-striped simple-tab">
        <tr>
            <th>Użytkownicy</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td><a href="../public/profile/${user.id}">${user.login}</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
