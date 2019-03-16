<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="edu.films.model.Book"%>
<%@ page import="java.util.*"%>
<%@ page import="edu.films.model.RatedBook" %>

<% String easterEgg = request.getParameter("param"); %>
<%=easterEgg != null ? "Param is:" + easterEgg : ""%> <br>

<a href = "books">Books </a>
<% if (session.getAttribute("currentUser") != null) {
%>
	<%--display user filter --%>
	<a href="books?filter=MyRated">My rated Books </a>
<%
	}
%>
:
	<br>
	<bookTags:list list = ""></bookTags:list>

<table>
	<%
		List<RatedBook> books = (List<RatedBook>) request.getAttribute("books");
        if (books != null) {
            for (RatedBook ratedBook : books) {
				Book book = ratedBook.getBook();
	%>
	<tr>
		<td>
            <br>
            <%=book.getName()%>,
            <%=book.getAuthor()%>
		</td>
		<td>
			<% if (session.getAttribute("currentUser")!=null){
				if (ratedBook.getRating() != null) {
			%>
			       <%--display rating--%>
				   <%=ratedBook.getRating()%>
			<%
				} else {
			%>
				  <%-- form rating --%>
				<form action="rate" method="post">
					<input type="hidden" name="action" value="books">
					<input type="hidden" name="id" value="<%=book.getId()%>	">
					<input type="radio" id="rate1" name="rating" value="1">
					<label for="rate1">1</label>

					<input type="radio" id="rate2" name="rating" value="2">
					<label for="rate2">2</label>

					<input type="radio" id="rate3" name="rating" value="3">
					<label for="rate3">3</label>

					<input type="submit" id="submit"
						   name="submit" value="RATE">

				</form>

			<%
				}
			%>


			<%
				}
			%>
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