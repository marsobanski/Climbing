<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: riffraff
  Date: 03.06.19
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    <link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
</head>
<body>
<div class="container"><br><br>

        <a class="btn btn-lg btn-dark center-block home-button-black" style="opacity: 0.8" href="/login">Podziel się z nami wspinaczkowymi dokonaniami!</a>

    <br><br><br>
        <a class="home-button btn btn-lg btn-block btn-light center-block home-button-white" href="/login">Zaloguj się</a>
        <a class="home-button btn btn-lg btn-block btn-success center-block home-button-green" href="/registration">Rejestracja</a>
        <a class="home-button btn btn-lg btn-block btn-info center-block home-button-blue" href="/routes">Drogi naszych użytkowników</a>

</div>
</body>
</html>
