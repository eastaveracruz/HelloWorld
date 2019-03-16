<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<jsp:useBean id="cool" class="edu.films.web.CoolDesignRegistryJsp" scope="application" />

<jsp:include page="${cool.DESIGN_COMMON}/pageHeader.jsp">
    <jsp:param  name="title" value="Errors"/>
</jsp:include>

<div id="container">
    <div class="page">
        <jsp:include page="${cool.DESIGN_COMMON}/header.jsp"></jsp:include>

        <jsp:include page="${cool.DESIGN}/error/main404.jsp"></jsp:include>

        <jsp:include page="${cool.DESIGN_COMMON}/footer.jsp"></jsp:include>
    </div>
</div>
<jsp:include page="${cool.DESIGN_COMMON}/pageFooter.jsp"></jsp:include>