<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Films</title>
</head>
<body style="position: relative; background-image: url(./img/108.png);">
<div id="wrapper" style="position:absolute; width:60%; margin-left: 20%; background-color: white; padding: 30px">
    <div align="center">
        <form action="FilmsServlet" method="get">
            <label for="serchText" style="font-family: Arial">Search by Title</label>
            <input type="text" name="action" id="serchText">
            <button type="submit">Search</button>
        </form>
    </div>
    <table align="center">
        <c:forEach items="${list}" var="film">
            <jsp:useBean id="film" scope="page" class="entity.Film"/>
            <tr >
                <td><img src="${film.img}" style="display:inline-block; width: 250px" ></td>
                <td valign="top">
                    <h3  style="text-align: center; font-family: Arial">${film.title}</h3>
                    <div style="width: 500px; padding-left: 20px; padding-bottom: 40px; font-family: Arial">${film.description}</div>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
