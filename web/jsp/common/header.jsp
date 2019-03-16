<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>--%>

	--------------   nice header  -----------------
<%@include file="/backToMain.html"%> <br>

	<% String logo = request.getParameter("logo");
        if (logo == null) {
            logo = "logo.png";
        }
    %>
    <div class="logos"><img src="${cool.image}/<%=logo%>"></div>

    <div id="user">
	<%--	<c:if test="">
		</c:if>--%>
			<% if (request.getParameter("message") != null) { %>
					<div class="message"><%=request.getParameter("message")%></div>
			<% } %>

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
	<div class="clr"></div>

	------------------------------------------------
<br>
</header>