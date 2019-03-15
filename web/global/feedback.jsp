<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<STYLE type=text/css>
.body { background-image:url('../images/GamesBackground.jpg');
		background-color:#cccccc; no-repeat center center fixed;
        -webkit-background-size: cover;
        -moz-background-size: cover;
        -o-background-size: cover;
        background-size: cover;}
</STYLE>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="body">
This is the page for feedback <br>
<h1>Submit your feedback please:</h1>
<form action="gadgets/feedbackSubmitted.jsp">
	<textarea type="text" name="comment" cols="45" rows="7"></textarea><br>
	<input type="submit" name="submit" value=" Save " />
</form>

<a href='../home.jsp'>Back to Home</a>

</body>
</html>