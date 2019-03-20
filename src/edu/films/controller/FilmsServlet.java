package edu.films.controller;

import edu.films.model.Film;
import edu.films.model.RatedFilm;
import edu.films.model.User;
import edu.films.service.FilmService;
import org.apache.commons.fileupload.FileItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * Servlet implementation class FilmsServlet
 */
public class FilmsServlet extends HttpServlet {
    //    private static final long serialVersionUID = 1L;
    private static final FilmService dao = new FilmService();
    private Random random = new Random();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String act = req.getParameter("action");
        act = act == null ? "" : act;
        String search = req.getParameter("search");
        switch (act) {
            case "search":
                search(search, req, resp);
                break;
            case "add":
                req.getRequestDispatcher("jsp/add.jsp").forward(req, resp);
                break;
            default:
                getAllFilms(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = (String) req.getParameter("title");
        String description = (String) req.getParameter("description");

//        //проверяем является ли полученный запрос multipart/form-data
//        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
//        if (!isMultipart) {
//            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
//            return;
//        }
////
//        // Создаём класс фабрику
//        DiskFileItemFactory factory = new DiskFileItemFactory();
//
//        // Максимальный буфера данных в байтах,
//        // при его привышении данные начнут записываться на диск во временную директорию
//        // устанавливаем один мегабайт
//        factory.setSizeThreshold(1024*1024);
//
//        // устанавливаем временную директорию
//        File tempDir = (File)getServletContext().getAttribute("javax.servlet.context.tempdir");
//        factory.setRepository(tempDir);
//
//        //Создаём сам загрузчик
//        ServletFileUpload upload = new ServletFileUpload(factory);
//
//        //максимальный размер данных который разрешено загружать в байтах
//        //по умолчанию -1, без ограничений. Устанавливаем 10 мегабайт.
//        upload.setSizeMax(1024 * 1024 * 10);
//
//        try {
//            List items = upload.parseRequest(req);
//            Iterator iter = items.iterator();
//
//            while (iter.hasNext()) {
//                FileItem item = (FileItem) iter.next();
//
//                if (item.isFormField()) {
//                    //если принимаемая часть данных является полем формы
//                    processFormField(item);
//                } else {
//                    //в противном случае рассматриваем как файл
//                    processUploadedFile(item);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//            return;
//        }

        dao.add(new Film(title, description));
        req.getRequestDispatcher("jsp/add.jsp").forward(req, resp);
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


//        req.setAttribute("list", dao.getByTitle(title));
//        req.getRequestDispatcher("/jsp/pages/films.jsp").forward(req, resp);
    }

    /**
     * Сохраняет файл на сервере, в папке upload.
     * Сама папка должна быть уже создана.
     *
     * @param item
     * @throws Exception
     */
    private void processUploadedFile(FileItem item) throws Exception {
        File uploadetFile = null;
        //выбираем файлу имя пока не найдём свободное
        do{
            String path = getServletContext().getRealPath("/upload/"+random.nextInt() + item.getName());
            uploadetFile = new File(path);
        }while(uploadetFile.exists());

        //создаём файл
        uploadetFile.createNewFile();
        //записываем в него данные
        item.write(uploadetFile);
    }

    /**
     * Выводит на консоль имя параметра и значение
     * @param item
     */
    private void processFormField(FileItem item) {
        System.out.println(item.getFieldName()+"="+item.getString());
    }
}
