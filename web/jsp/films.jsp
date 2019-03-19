<%@ page import="edu.films.model.Film" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="film/header.jsp"></jsp:include>

<div id="wrapper" style="position:absolute; width:60%; margin-left: 20%; background-color: white; padding: 30px">

    <table align="center">
        <c:forEach items="${list}" var="rated">
            <jsp:useBean id="rated" scope="page" class="edu.films.model.RatedFilm"/>
            <c:set var="film" scope="page" value="${rated.book}"></c:set>
            <jsp:useBean id="film" scope="page" class="edu.films.model.Film"/>

            <tr>
                <td><img src="${rated.book.img}" style="display:inline-block; width: 250px"></td>
                <td valign="top">
                    <h3 style="text-align: center; font-family: Arial">${film.title}</h3>
                    <div style="width: 500px; padding-left: 20px; padding-bottom: 40px; font-family: Arial">${film.description}</div>
                </td>
            </tr>
            <tr>
                <td>
                    <% if (session.getAttribute("currentUser") != null) {
                        if (rated.getRating() != null) {
                    %>
                        <%--display rating--%>
                    <%=rated.getRating()%>
                    <%
                    } else {
                    %>
                        <%-- form rating --%>
                    <form action="rate" method="post">
                        <input type="hidden" name="action" value="films">
                        <input type="hidden" name="id" value="<%=film.getId()%>	">
                        <input type="radio" id="rate1" name="rating" value="1">
                        <label for="rate1">1</label>

                        <input type="radio" id="rate2" name="rating" value="2">
                        <label for="rate2">2</label>

                        <input type="radio" id="rate3" name="rating" value="3">
                        <label for="rate3">3</label>

                        <input type="submit" id="submit"
                               name="submit" value="RATE">
                    </form>
                </td>
            </tr>


            <%
                }
            %>


            <%
                }
            %>


        </c:forEach>
    </table>

</div>
</body>
</html>
