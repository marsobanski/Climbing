<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: riffraff
  Date: 07.06.19
  Time: 09:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Profile</title>
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
                <form:hidden path="id"/>

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
                    <form:input value="00000000000000000000" type="password" path="password" id="passwordId" cssClass="form-control"/>
                    <form:errors path="password" element="div"/>
                </div>
                <div class="form-group">
                    <label for="publicProfileId">Profil publiczny:</label>
                    <c:if test="${user.publicProfile}">
                        <input type="checkbox" name="publicProfile"   id="publicProfileId" cssClass="form-control" checked>
                    </c:if>
                    <c:if test="${!user.publicProfile}">
                        <input type="checkbox" name="publicProfile"   id="publicProfileId" cssClass="form-control">
                    </c:if>


                </div>
                <input type="submit" value="Zatwierdź zmiany" class="home-button btn-success btn">
                <a href="/user/dashboard" class="btn-dark btn home-button">Cofnij</a>


            </div>
        </div>
    </form:form>
</div>
</body>
</html>
