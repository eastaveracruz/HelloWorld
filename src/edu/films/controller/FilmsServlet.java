package edu.films.controller;

import edu.films.model.Film;
import edu.films.model.RatedFilm;
import edu.films.model.User;
import edu.films.service.FilmService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class FilmsServlet
 */
public class FilmsServlet extends HttpServlet {
    //    private static final long serialVersionUID = 1L;
    private static final FilmService dao = new FilmService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = req.getParameter("action") + req.getParameter("search");
        switch (result) {
            case "serchddddddddddddddd":
                search(result, req, resp);
                break;
            case "adddddddddddddddd":
                req.getRequestDispatcher("/jsp/add.jsp").forward(req, resp);
                break;
            default:
                getAllFilms(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = (String) req.getParameter("title");
        String description = (String) req.getParameter("description");
        dao.add(new Film(title, description));
        req.getRequestDispatcher("/jsp/add.jsp").forward(req, resp);
    }

    private void getAllFilms(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<RatedFilm> booksList;
        Object currentUser = req.getSession().getAttribute("currentUser");
        if (currentUser != null) {
                booksList = dao.getRatedFilm((User) currentUser);
        } else {
            booksList = dao.getRatedFilm();
        }
        req.setAttribute("list", booksList);
        req.getRequestDispatcher("/jsp/films.jsp").forward(req, resp);
    }

    private void search(String title, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("list", dao.getByTitle(title));
        req.getRequestDispatcher("/jsp/pages/films.jsp").forward(req, resp);
    }
}
