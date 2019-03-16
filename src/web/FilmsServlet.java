package web;

import dao.Dao;
import entity.Film;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class FilmsServlet
 */
public class FilmsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Dao dao = new Dao();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action){
            case "list": getAllFilms(req, resp); break;
            case "add": req.getRequestDispatcher("WEB-INF/pages/add.jsp").forward(req, resp); break;
            default: search(action, req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = (String) req.getParameter("title");
        String description = (String) req.getParameter("description");
        dao.add(new Film(title, description));
        req.getRequestDispatcher("WEB-INF/pages/add.jsp").forward(req, resp);
    }

    private void getAllFilms(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("list", dao.getAll());
        req.getRequestDispatcher("/WEB-INF/pages/films.jsp").forward(req, resp);
    }

    private void search(String title, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("list", dao.getByTitle(title));
        req.getRequestDispatcher("/WEB-INF/pages/films.jsp").forward(req, resp);
    }
}
