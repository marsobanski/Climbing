<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: riffraff
  Date: 04.06.19
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
    <script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    <link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
</head>
<body>
<div class="container">
    <form:form cssClass="white-form" method="post" modelAttribute="user">
        <header>Rejestracja</header>
        <div class="card" style="opacity: 0.8;">
            <div class="card-body">

                <div class="form-group ">
                    <form:hidden path="admin"/>
                    <form:hidden path="publicProfile"/>
                </div>
                <div class="form-group ">
                    <label for="loginId">Login:</label>
                    <form:input type="text" path="login" id="loginId" cssClass="form-control"/>
                    <form:errors path="login" element="div"/>
                </div>
                <div class="form-group ">
                    <label for="emailId">Email:</label>
                    <form:input type="email" path="email" id="emailId" cssClass="form-control"/>
                    <form:errors path="email" element="div"/>
                </div>
                <div class="form-group ">
                    <label for="passwordId">Hasło:</label>
                    <form:input type="password" path="password" id="passwordId" cssClass="form-control"/>
                    <form:errors path="password" element="div"/>
                </div>
                <input type="submit" value="Zarejestruj się" class="home-button btn-success btn">
                <a href="/login" class="home-button btn btn-info">Logowanie</a>
                <a href="/" class="btn-dark btn home-button">Strona główna</a>


            </div>
        </div>
    </form:form>
</div>
</body>
</html>
