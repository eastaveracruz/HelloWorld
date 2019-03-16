<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="edu.films.model.Book"%>
<%@ page import="java.util.*"%>

<% String easterEgg = request.getParameter("param"); %>
<%=easterEgg != null ? "Param is:" + easterEgg : ""%> <br>

Books:
	<br>
	<bookTags:list list = ""></bookTags:list>

<table>
	<%
		List<Book> books = (List<Book>) request.getAttribute("books");
        if (books != null) {
            for (Book book : books) {
    %>
	<tr>
		<td>
            <br>
            <%=book.getName()%>,
            <%=book.getAuthor()%>
		</td>
		<td>
			<form action="rate" method="post">
				<input type="hidden" name="action" value="books">
				<input type="hidden" name="id" value="<%=book.getAuthor()%>	">

				<input type="radio" id="rate1" name="rating" value="1">
				<label for="rate1">1</label>

				<input type="radio" id="rate2" name="rating" value="2">
				<label for="rate2">2</label>

				<input type="radio" id="rate3" name="rating" value="3">
				<label for="rate3">3</label>

				<input type="submit" id="submit"
					   name="submit" value="RATE">

			</form>
		</td>
	</tr>
    <%
            }
        }
	%>
</table>
	<br>
	<br>
	<!-- example of JSTL -->
	<hr>
	${list[0]} <br>
	${mapo.book1}
	${mapo.book2}
	${mapo.book3}