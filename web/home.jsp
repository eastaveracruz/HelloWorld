<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<STYLE type=text/css>
.body { background-image:url('images/MMH6_1920x1080.jpg');
		background-color:#cccccc; }
.label {color : black; font-weight : bold;}
a:link	 { color: #FFFFCE; text-decoration: none; }
a:visited	{ color: #FFFFCE; text-decoration: none; }
a:active	{ color: #CCFFCC; text-decoration: none; }
a:hover	{ color: #FFFF63; text-decoration: none; }
.cell {background-color: #000000;}
</STYLE>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Database for Testers Home Page</title>
</head>
<body class="body">
<jsp:include page="global/gadgets/homeLoggedIn.jsp" />

<table border="1" style="height: 100%; width: 100%">
<tr>
<th class="cell"><a href="global/profile.jsp">My Profile</a></th>
<th class="cell"><a href="global/tasks.jsp">My Tasks</a></th>
<!--<th class="cell"><a href="global/games.jsp">My Games</a></th>-->
<th class="cell"><a href="Games">My Games</a></th>
<th class="cell"><a href="global/feedback.jsp">Feedback</a></th>
</tr>
</table>

</body>
</html>