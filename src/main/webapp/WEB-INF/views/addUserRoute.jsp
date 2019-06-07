<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: riffraff
  Date: 04.06.19
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Route</title>
    <script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    <link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
</head>
<body>
<div class="container">
    <form:form cssClass="white-form" cssStyle="opacity: 0.8" method="post" modelAttribute="userRoute">
        <div class="card">
            <div class="card-body">

                <label for="routeId">Droga:</label>
                <form:select path="route.id" items="${routes}" id="routeId" itemLabel="name" itemValue="id"
                             cssClass="form-control"/>
                <form:errors path="route" element="div"/>

                <label for="timeId">Czas wejścia:</label>
                <form:input type="time" step="1" path="time" id="timeId" cssClass="form-control"/>
                <form:errors path="time" element="div"/>

                <label for="dateId">Data wejścia:</label>
                <form:input type="date" path="date" id="dateId" cssClass="form-control"/>
                <form:errors path="date" element="div"/>

                <label for="descriptionId">Opis wejścia:</label>
                <form:textarea maxlength="150" cols="80" rows="4" path="description" id="descriptionId"
                               cssClass="form-control"/>
                <form:errors path="description" element="div"/>

                <input type="submit" value="Dodaj drogę" class="btn btn-success">
                <a class="btn btn-warning" href="/user/routes/all">Cofnij do listy</a>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>
