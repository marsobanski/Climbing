<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: riffraff
  Date: 05.06.19
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Route Details</title>
    <script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    <link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
</head>
<body>
<div class="container white-background">
    <%@include file="/WEB-INF/views/header.jspf" %>
    <div class="row">
        <div class="col center-block rt-nme">
            ${userRoute.route.name}
        </div>
    </div>
    <br>
    <br>
    <div class="row">
        <div class="col-5">
            <table class="table table-striped simple-tab">
                <tr>
                    <th>Skała</th>
                    <td>${userRoute.route.rock.name}</td>
                </tr>
                <tr>
                    <th>Rejon</th>
                    <td>${userRoute.route.rock.area.name}</td>
                </tr>
                <tr>
                    <th>Data</th>
                    <td>${userRoute.date}</td>
                </tr>
                <tr>
                    <th>Czas</th>
                    <td>${userRoute.time}</td>
                </tr>
                <tr>
                    <th>Poziom trudności</th>
                    <td>${userRoute.route.difficulty}</td>
                </tr>
            </table>
        </div>
        <div class="col-7">
            <div class="row">
                <div class="col text-center text-area table simple-tab home-button">
                    Opis wejścia:
                </div>
            </div>
            <div class="row">
                <div class="col text-center text-area">
                    ${userRoute.description}
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col text-center">
            Komentarze:
        </div>
    </div>
    <c:forEach var="comment" items="${comments}">
    <div class="row">
        <div class="col-3 text-center">
            ${comment.user.login} dnia ${comment.creationDate}
        </div>
    </div>
    <div class="row">
        <div class="col text-area text-center table com-win simple-tab">
            ${comment.text}
        </div>
    </div>
    </c:forEach>
    <form:form cssClass="form-group white-form" method="post" modelAttribute="comment">
        <form:hidden path="creationDate"/>
        <div class="form-group ">
            <form:textarea placeholder="Dodaj komentarz" path="text" cols="100" rows="3" maxlength="255" id="textId" cssClass="form-control"/>
            <form:errors path="text" element="div"/>
        </div>
        <input class="btn btn-success" type="submit" value="Dodaj komentarz">
        <a class="btn btn-warning" href="/user/routes/all">Powrót</a>
    </form:form>



</div>
</body>
</html>
