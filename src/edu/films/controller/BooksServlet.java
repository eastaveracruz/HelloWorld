package edu.films.controller;

import edu.films.model.RatedBook;
import edu.films.model.User;
import edu.films.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static edu.films.service.Filter.MYRATED;

/**
 *
 */
//TODO extract parameters
public class BooksServlet extends HttpServlet {

    BookService bookService = BookService.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<RatedBook> booksList;
        Object currentUser = request.getSession().getAttribute("currentUser");
        if (currentUser != null) {
            //TODO handle if  wrong filter perameter
            //TODO convert to enum
            if ("myRated".equalsIgnoreCase(request.getParameter("filter"))) {
                booksList = bookService.getRatedBook((User) currentUser, MYRATED);
            } else {
                booksList = bookService.getRatedBook((User) currentUser);
            }
        } else {
            booksList = bookService.getRatedBook();
        }
        request.setAttribute(WEB_CONSTANTS.ATTR_BOOKS, booksList);
        request.getRequestDispatcher(WEB_CONSTANTS.VIEW_BOOKS_JSP).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
