<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FILMS</title>
</head>
<body style="position: relative; background-image: url(./resources/films_img/108.png);">
<div id="header" style=" width:60%; margin-left: 20%; background-color: white; padding: 30px; margin-bottom: 30px">
    <a href="films?action=add" style="color: indianred">ADD NEW FILMS</a><br>
    <a href="index.html" style="color: indianred">BACK TO MAIN</a>
    <div align="right">
        <form action="films" method="get">
            <label for="serchText" style="font-family: Arial">Search by Title</label>
            <input type="text" name="search" id="serchText">
            <input type="hidden" name="action" value="search">
            <button type="submit">Search</button>
        </form>
    </div>

    <jsp:useBean id="cool" class="edu.films.web.CoolDesignRegistryJsp" scope="application" />
    <% if (session.getAttribute("currentUser") != null) { %>
    <div class="name">${currentUser.name}</div>
    <div class="links">
        <ul>
            <li><a href="${cool.ACTION_LOGOUT}&action=${param.action}"> logout</a></li>
        </ul>
    </div>
    <%} else {		%>
    <form action="${cool.ACTION_LOGIN}" method="post">
        <input type="text" name="user">
        <input type="hidden" name="action" value="${param.action}">
    </form>
    <%}		%>
</div>