package edu.films.controller;

import edu.films.service.FilmService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static edu.films.controller.WEB_CONSTANTS.ATTR_FILMS;

/**
 *
 */
public class FilmsServlet extends HttpServlet {

    FilmService filmService = new FilmService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List filmsList = filmService.getFilms();
        request.setAttribute(ATTR_FILMS, filmsList);
        request.getRequestDispatcher(WEB_CONSTANTS.VIEW_FILMS_JSP).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
