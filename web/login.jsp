<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<STYLE type=text/css>
html {
    background: url('images/handmadepaper.png');
    font-size: 14pt;
}
.loginform ul {
        padding: 0;
        margin: 0;
    }
    .loginform li {
        display: inline;
        float: left;
    }
.errorMessage { color: red; }
.label {color : black; font-weight : bold;}

.loginform input:not([type=submit]) {
        padding: 5px;
        margin-right: 10px;
        border: 1px solid rgba(0, 0, 0, 0.3);
        border-radius: 3px;
        box-shadow: inset 0px 1px 3px 0px rgba(0, 0, 0, 0.1),
                    0px 1px 0px 0px rgba(250, 250, 250, 0.5) ;
    }
    
    .loginform input[type=submit] {
        border: 1px solid rgba(0, 0, 0, 0.3);
        background: #64c8ef; /* Old browsers */
        background: -moz-linear-gradient(top,  #64c8ef 0%, #00a2e2 100%); /* FF3.6+ */
        background: -webkit-gradient(linear, left top, left bottombottom, color-stop(0%,#64c8ef), color-stop(100%,#00a2e2)); /* Chrome,Safari4+ */
        background: -webkit-linear-gradient(top,  #64c8ef 0%,#00a2e2 100%); /* Chrome10+,Safari5.1+ */
        background: -ms-linear-gradient(top,  #64c8ef 0%,#00a2e2 100%); /* IE10+ */
        filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#64c8ef', endColorstr='#00a2e2',GradientType=0 ); /* IE6-9 */
        color: #fff;
        padding: 5px 15px;
        margin-right: 0;
        margin-top: 2px;
        border-radius: 3px;
        text-shadow: 1px 1px 0px rgba(0, 0, 0, 0.3);
    }
</STYLE>
<%	
		if (request.getAttribute("message") != null) 
        out.println("<b class=\"errorMessage\">" + request.getAttribute("message") + "!</b>");
%>
<BR>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<h2>Dear Colleagues!</h2>
<h2>Thank you for attending my database training. To perform home tasks please login: </h2>
<br>

<br>
<!--<form action="LoginServlet" method="post">-->
<!--	<p class="label">Username: <input type="text" name="userName" /><br></p>-->
<!--	<p class="label">Password: <input type="password" name=password><br></p><br><br>-->
<!--	<input type="submit" value="Log in" /><br>-->
<!-- </form>-->
 
 
 <section class="loginform cf">
<form name="login" action="LoginServlet" method="post" accept-charset="utf-8">
    <ul>
        <li><label for="userName">UserName: </label>
        <input type="text" name="userName" placeholder="enter your name" required value="user1"></li>
        <li><label for="password">Password: </label>
        <input type="password" name="password" placeholder="password" required value="user1"></li>
        <li>
        <input type="submit" value="Login"></li>
    </ul>
</form>
</section>

</body>
</html>