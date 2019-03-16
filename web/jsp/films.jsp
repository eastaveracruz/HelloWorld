<%@ page import="edu.films.model.Film" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: arzo
  Date: 3/9/2019
  Time: 5:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="../v0/error.jsp" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<jsp:include page="common/header.jsp">
    <jsp:param  name="title" value="Errors"/>
</jsp:include>

Hello, this is list of films:
<br>
<ol>
    <%
        List<Film> films = (List<Film>) request.getAttribute("films");
        if (films != null) {
            for (Film film : films) {
    %>
    <li>
        <%=film.getName()%>,
        <%=film.getGenre()%>
    </li>
    <%
            }
        }
    %>
    <br>
</ol>
$END$
</body>
</html>
