<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id="user" class="test.training.user.UserProfile" scope="session"/> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<STYLE type=text/css>
.body { background-image:url('../images/crysis.jpg');
		background-color:#cccccc; }
</STYLE>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Profile page</title>
</head>
<BODY class="body">
<table>
	<tr>
	<th><h1>My profile:</h1></th>
	</tr>
	
	<tr>
		<td><h2>User Name :</h2></td>	
		<td><h2><jsp:getProperty name="user" property="username" /></h2></td>
	</tr>
	<tr>
		<td><h2>Last Name :</h2></td>
		<td><h2><jsp:getProperty name="user" property="email" /></h2></td>
	</tr>
	<tr>
		<td><h2>Address :</h2></td>
		<td><h2><jsp:getProperty name="user" property="position" /></h2></td>
	</tr>
</table>
<a href='../home.jsp'>Back to Home</a>
</BODY>
</HTML>