<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.body {
	background-image:url('../images/TasksBackGround.jpg');
	background-color: #cccccc;
}
.table {
	font-size:200%;
	width='30%';border="0";cellspacing="0";cellpadding="0"
} 
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Download Tasks</title>
</head>
<body class="body">
<form action="DownloadTask" method="post" >

<table class="table"  > 
  <tr>
  	<th colspan="2">Please select task to download:</th>
  </tr>
  <tr>
  	<td width='20%'>Lecture 1:</td>
    <td><input type="radio" name="taskName" value="task1.docx" checked/> Task1</td>
  </tr>
   <tr>
     <td>&nbsp;</td>
  </tr>
  <tr>
  	<td width='20%'>Lecture 2:</td>
    <td><input type="radio" name="taskName" value="task2.docx"/> Task2<br>
    <input type="radio" name="taskName" value="task3.docx"/> Task3</td>
  </tr>
   <tr>
     <td>&nbsp;</td>
  </tr>
  <tr>
  	<td width='20%'>Lecture 3:</td>
    <td><input type="radio" name="taskName" value="task4.docx"/> Task4.1</td>
  </tr>
   <tr>
     <td>&nbsp;</td>
  </tr>
  <tr>
  	<td width='20%'>Lecture 4:</td>
    <td><input type="radio" name="taskName" value="task4.docx"/> Task4.2</td>
  </tr>
   <tr>
     <td>&nbsp;</td>
  </tr>
  <tr>
  	<td width='20%'>Lecture 5:</td>
    <td><input type="radio" name="taskName" value="task5.docx"/> Task5<br>
    <input type="radio" name="taskName" value="task6.docx"/> Task6<br>
    <input type="radio" name="taskName" value="task7.docx"/> Task7
    </td>
  </tr>
   <tr>
     <td>&nbsp;</td>
  </tr>
  <tr>
    <td colspan="2"><input type="submit" name="submit" value="Download"/></td>
  </tr>
</table>

</form>

<a href='../home.jsp'>Back to Home</a>
</body>
</html>