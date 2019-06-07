<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: riffraff
  Date: 04.06.19
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Routes</title>
    <script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    <link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
    <script>
        function confirmDelete(id, information) {
            if (confirm("Czy na pewno chcesz usunąć drogę " + information + "'?")) {
                window.location.href = "/user/routes/delete/" + id;
            }
        }
    </script>
</head>
<body>
<div class="container white-background">
    <%@include file="/WEB-INF/views/header.jspf"%>

    <table class="table table-striped simple-tab">
        <tr>
            <th><a class="black-txt" href="/user/routes/sort/name"> Nazwa Drogi</a></th>
            <th><a class="black-txt" href="/user/routes/sort/time"> Czas wejścia</a></th>
            <th><a class="black-txt" href="/user/routes/sort/date"> Data wejścia</a></th>
            <th><a class="black-txt" href="/user/routes/sort/diff"> Trud</a></th>
            <th><a class="black-txt" href="/user/routes/sort/rock"> Nazwa Skały</a></th>
            <th><a class="black-txt" href="/user/routes/sort/area"> Rejon</a></th>
            <th>Akcja</th>
        </tr>
        <c:forEach var="userRoute" items="${userRoutes}">
            <tr>
                <td>${userRoute.route.name}</td>
                <td>${userRoute.time}</td>
                <td>${userRoute.date}</td>
                <td>${userRoute.route.difficulty}</td>
                <td>${userRoute.route.rock.name}</td>
                <td>${userRoute.route.rock.area.name}</td>
                <td>
                    <a class="btn home-button-green btn-success" href="/user/routes/edit/${userRoute.id}">Edytuj</a>
                        <%--<a href="/books/delete/${book.id}">Usuń</a>--%>
                    <a class="btn home-button-red btn-danger" href="#" onclick="confirmDelete(${userRoute.id}, '${userRoute.route.name}')">Usuń</a>
                    <a class="btn home-button-blue btn-info" href="/user/routes/details/${userRoute.id}">Szczegóły</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
