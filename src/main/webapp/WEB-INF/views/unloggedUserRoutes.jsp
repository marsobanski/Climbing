<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: riffraff
  Date: 05.06.19
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Unlogged User Routes</title>
    <script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    <link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
</head>
<body>
<div class="container white-background">
<table class="table table-striped simple-tab">
    <tr>
        <th>Użytkownik</th>
        <th>Nazwa Drogi</th>
        <th>Czas wejścia</th>
        <th>Data wejścia</th>
        <th>Poziom Trudności</th>
        <th>Nazwa Skały</th>
        <th>Rejon</th>
        <th>Opis</th>
    </tr>
    <c:forEach var="userRoute" items="${userRoutes}">
        <tr>
            <td>${userRoute.user.login}</td>
            <td>${userRoute.route.name}</td>
            <td>${userRoute.time}</td>
            <td>${userRoute.date}</td>
            <td>${userRoute.route.difficulty}</td>
            <td>${userRoute.route.rock.name}</td>
            <td>${userRoute.route.rock.area.name}</td>
            <td>${userRoute.description}</td>
        </tr>
    </c:forEach>
</table>
    <a class="btn btn-success center-block home-button" href="/">Powrót</a>
</div>
</body>
</html>
