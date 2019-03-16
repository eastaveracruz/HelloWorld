<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: arzo
  Date: 3/9/2019
  Time: 5:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<%@include file="/backToMain.html"%>


This is error: <%=exception%>
<br>
<hr>
<br>

Details: <%

    PrintWriter brWriter = new PrintWriter(out) {
        @Override
        public void print(String x) {
            super.print(x.replace("\t", "<br>"));
        }
    };
    exception.printStackTrace(brWriter);%>
$END$
</body>
</html>
