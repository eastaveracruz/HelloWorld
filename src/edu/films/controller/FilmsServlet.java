package edu.films.controller;

import edu.films.model.Film;
import edu.films.model.RatedFilm;
import edu.films.model.User;
import edu.films.service.FilmService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

import static edu.films.controller.WEB_CONSTANTS.UPLOAD_DIR;

/**
 * Servlet implementation class FilmsServlet
 */

@MultipartConfig
public class FilmsServlet extends HttpServlet {
    //    private static final long serialVersionUID = 1L;
    private static final FilmService dao = new FilmService();
    private Random random = new Random();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String act = req.getParameter("action");
        act = act == null ? "" : act;
        switch (act) {
            case "search":
                String search = req.getParameter("search");
                search(search, req, resp);
                break;
            case "add":
                req.getRequestDispatcher("jsp/add.jsp").forward(req, resp);
                break;
            case "delete":
                int id = Integer.parseInt(req.getParameter("id"));
                dao.delete(id);
            default:
                getAllFilms(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = (String) req.getParameter("title");
        String description = req.getParameter("description"); // Retrieves <input type="text" name="description">

        //Загрузка файла
        Part filePart = req.getPart("file"); // Retrieves <input type="file" name="file">

        if (nullCheck(title)) {
            dao.add(new Film(title, description, fileUpload(filePart)));
            req.getRequestDispatcher("jsp/add.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("jsp/error.jsp").forward(req, resp);
        }
    }

    private boolean nullCheck(String... args) {
        for (String s : args) {
            if (s == null || "".equals(s)) {
                return false;
            }
        }
        return true;
    }

    private String fileUpload(Part filePart) {
        //исходное имя файла
        String oldFileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        String webPass = "." + UPLOAD_DIR + "/" + oldFileName;
        File folder = new File(getServletContext().getRealPath(webPass));
        try {
            if (!folder.exists()) {
                folder.getParentFile().mkdir();
                System.out.println(folder.createNewFile());
            }
            InputStream fileContent = filePart.getInputStream();
            OutputStream writer = new FileOutputStream(folder);
            byte[] bytes = new byte[1024];
            while (fileContent.available() > 0) {
                int count = fileContent.read(bytes);
                writer.write(bytes, 0, count);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return webPass;
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
        List<RatedFilm> booksList;
        Object currentUser = req.getSession().getAttribute("currentUser");
        if (currentUser != null) {
            booksList = dao.getByTitle(title, (User) currentUser);
        } else {
            booksList = dao.getByTitle(title);
        }
        req.setAttribute("list", booksList);
        req.getRequestDispatcher("/jsp/films.jsp").forward(req, resp);
    }
}
