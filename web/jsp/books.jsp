<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:useBean id="cool" class="edu.films.web.CoolDesignRegistryJsp" scope="application" />

<jsp:include page="${cool.DESIGN_COMMON}/pageHeader.jsp">
    <jsp:param  name="title" value="Hello, Books"/>
</jsp:include>

<div id="container">
    <div class="page">
        <jsp:include page="${cool.DESIGN_COMMON}/header.jsp">
            <jsp:param  name="action" value="books"/>
            <jsp:param  name="logo" value="logo-book.png"/>
        </jsp:include>

        <jsp:include page="${cool.DESIGN}/book/main.jsp"></jsp:include>

        <jsp:include page="${cool.DESIGN_COMMON}/footer.jsp"></jsp:include>
    </div>
</div>
<jsp:include page="${cool.DESIGN_COMMON}/pageFooter.jsp"></jsp:include>

