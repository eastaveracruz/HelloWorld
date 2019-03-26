<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${applicationScope.title}</title>
    <link rel="stylesheet" href="./resources/css/films.css">
</head>
<body style="position: relative; background-image: url(./resources/films_img/108.png);">
<div id="header" style=" width:60%; margin-left: 20%; background-color: white; padding: 30px; margin-bottom: 30px">
    <div id="menu">
        <a href="films?action=add" style="color: indianred">ADD NEW FILMS</a> |
        <a href="index.html" style="color: indianred">BACK TO MAIN</a>
    </div>

    <div align="left" id="search">
        <form action="films" method="get">
            <label for="serchText" style="font-family: Arial">Search by Title</label>
            <input type="text" name="search" id="serchText">
            <input type="hidden" name="action" value="search">
            <button type="submit">Search</button>
        </form>
    </div>

    <jsp:useBean id="cool" class="edu.films.web.CoolDesignRegistryJsp" scope="application"/>
    <div align="right" id="login">
        <c:if test="${sessionScope.currentUser.name != null}">
            <div class="name">
                Hello <span id="user_name">${currentUser.name}</span> |
                <a href="${cool.ACTION_LOGOUT}&action=${param.action}"> logout</a>
            </div>
        </c:if>
        <c:if test="${sessionScope.currentUser.name == null}">
            <form action="${cool.ACTION_LOGIN}" method="post">
                <label for="user">LogIn</label>
                <input type="text" name="user" id="user">
                <input type="hidden" name="action" value="${param.action}">
            </form>
        </c:if>
    </div>
</div>