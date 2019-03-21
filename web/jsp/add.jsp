<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Film</title>
    <link rel="stylesheet" href="./resources/css/films.css">
</head>
<body>
<div align="center">
    <a href="films" style="color: indianred">FILMS LIST</a><br>
    <h2 style="font-size: 20px">Add Film</h2>
    <form action="films" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td><label for="title">Title</label></td>
                <td><input type="text" name="title" id="title" required></td>
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
                <td>
                    <button type="submit">Save</button>
                </td>
            </tr>
        </table>


        <br>
    </form>
</div>
</body>
</html>
