<%@ page import="java.io.PrintWriter" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isErrorPage="true" %>

This is error: <%=exception%>
<br>
<hr>
<br>
Details:
<br>
<%

    PrintWriter brWriter = new PrintWriter(out) {
        @Override
        public void print(String x) {
            super.print(x.replace("\t", "<br>"));
        }
    };
    exception.printStackTrace(brWriter);

%>
