<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<STYLE type=text/css>
.body { background-image:url('images/gamesB.jpg');
		background-color:#cccccc; no-repeat center center fixed;
        -webkit-background-size: cover;
        -moz-background-size: cover;
        -o-background-size: cover;
        background-size: cover;}
.find {
	   left:0px;
	   width:15%;
    }
 .add {
	   left:0px;
    }
</STYLE>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Games</title>
</head>
<body class="body"> <!-- onload="document.forms[0].submit();" -->

This is the page for games <br>

<jsp:include page="gadgets/showNewGames.jsp"/>
<table >
	<tr>
		<td class="find" ><jsp:include page="gadgets/findGames.jsp"></jsp:include></td>
	</tr>
	<tr>
	<td>&nbsp;</td>
	</tr>
	<tr>
		<td class="add"><b>Or you can add a new <a href="${pageContext.request.contextPath}/global/gadgets/addGame.jsp">Game</a></b></td>
	</tr>
</table>
<br>
<br>
<a href="${pageContext.request.contextPath}/home.jsp">Back to Home</a>

</body>
</html>