<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="user" class="test.training.user.UserProfile" scope="session"/>
<jsp:setProperty name="user" property="username" value='<%=request.getSession().getAttribute("currentSessionUser")%>' /> 
<html>
<STYLE type=text/css>
.label {color : red; font-weight : bold;}
.logout {color : red; font-weight : bold; float : right; position:relative; top:-100px;}
</STYLE>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<h1 class="label">Hi <jsp:getProperty name="user" property="username"/></h1>
	<h1 class="label">Thank you for attending the database training!</h1>
	<h2><a href="logout.jsp" class="logout">Logout</a></h2>
</body>
</html>