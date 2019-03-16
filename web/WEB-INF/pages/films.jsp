<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Films</title>
</head>
<body>
<div align="center">
    <form action="FilmsServlet" method="get">
        <input type="text" name="action">
        <button type="submit">Search</button>
    </form>
</div>
<table align="center">
    <c:forEach items="${list}" var="film">
        <jsp:useBean id="film" scope="page" class="entity.Film"/>
        <tr >
            <td><img src="${film.img}" width="100" height="200"></td>
            <td valign="top">
                <h3  style="text-align: center; font-family: Arial">${film.title}</h3>
                <div style="width: 400px; padding-left: 20px; padding-bottom: 40px; font-family: Arial">${film.description}</div>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
