<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Film</title>
</head>
<body>
<div align="center">
    <a href="FilmsServlet?action=list" style="color: indianred">FILMS LIST</a><br>
    <h2 style="font-family: Arial; font-size: 20px">Add Film</h2>
    <form action="FilmsServlet" method="post">
        <table>
            <tr>
                <td><label for="title">Title</label></td>
                <td><input type="text" name="title" id="title"></td>
            </tr>
            <tr>
                <td><label for="description">Description</label></td>
                <td><input type="text" name="description" id="description"></td>
            </tr>
            <tr>
                <td><label for="file">Choos image</label></td>
                <td><input type="file" name="file" id="file"></td>
            </tr>
            <tr>
                <td></td>
                <td><button type="submit">Save</button></td>
            </tr>
        </table>



        <br>
    </form>
</div>
</body>
</html>
