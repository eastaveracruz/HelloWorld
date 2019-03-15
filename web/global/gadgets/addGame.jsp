<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="/WEB-INF/tlds/CustomTags.tld" prefix="ct" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<STYLE type=text/css>
html {
    background: url('../../images/handmadepaper.png');
    font-size: 14pt;
}
.addform ul {
        padding: 0;
        margin: 0;
    }
 .addform {
       float:left;
    }
   
.addform li {
       
       list-style-type: none;
  }
 .field {
 	clear:both; text-align:right; line-height:25px;  
       padding: 0; margin: 0;
 }
  label {float:left; padding-right:10px;}
 .addform input:not([type=submit]) {
        padding: 5px;
        margin-right: 10px;
        margin-top: 1px;
        border: 1px solid rgba(0, 0, 0, 0.3);
        border-radius: 3px;
        box-shadow: inset 0px 1px 3px 0px rgba(0, 0, 0, 0.1),
                    0px 1px 0px 0px rgba(250, 250, 250, 0.5) ;
    }
</STYLE>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Found Games</title>
</head>
<body>
<section class="addform cf">
<form action="${pageContext.request.contextPath}/global/gadgets/AddNewGame" method="get">
	<b>Please enter game details:</b><br>
<ul>
<div class="field">
	<li><label for="name">Name: </label> 
	<input type="text"	name="name" placeholder="e.g. Heroes 6" required maxlength="20" ></li>
	<li><label for="genre">Genre: </label>
	<input type="text" name="genre" placeholder="e.g. Action" maxlength="20"></li>
	<li><label for="developer">Developer: </label>
	<input type="text" name="developer" placeholder="e.g. Starbreeze" maxlength="20"></li>
</div>
	<li><label for="platform">Supported Platforms: </label><br>
	<input type="checkbox" name="pc" value="PC">PC <br>
	<input type="checkbox" name="xbox" value="XBox360">XBox360 <br>
	<input type="checkbox" name="ps" value="PS3">PS3 <br></li> 
	<li><input type="submit" value="Add Game"></li>
</ul>
</section>
</body>
</html>