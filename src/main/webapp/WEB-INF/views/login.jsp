<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: riffraff
  Date: 04.06.19
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    <link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
</head>
<body>
<div class="container">


    <form class="white-form" method="post">

        <header>Login</header>

        <div class="card" style="opacity: 0.8">
            <div class="card-body">

                <div class="form-group ">
                    <label for="loginId">Login:</label>
                    <input type="text" name="login" id="loginId" class="form-control">
                </div>

                <div class="form-group">
                    <label for="passwordId">Hasło:</label>
                    <input type="password" name="password" id="passwordId" class="form-control">
                </div>

                <c:if test="${isLogged == false}">
                    <div class="error">Logowanie nie powiodło się</div>
                    <br><br>
                </c:if>

                <input type="submit" value="Zaloguj się" class="home-button btn btn-info">
                <a href="/registration" class="home-button btn btn-success">Rejestracja</a>
                <a href="/" class="btn-dark btn home-button">Strona główna</a>

            </div>
        </div>

    </form>

</div>
</body>
</html>
