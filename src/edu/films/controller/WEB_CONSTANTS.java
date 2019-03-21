package edu.films.controller;

/**
 *
 */
public class WEB_CONSTANTS {
    public static final String JSP_BASE_DIR = "/jsp/";
    public static final String VIEW_FILMS_JSP = JSP_BASE_DIR + "films.jsp";
    public static final String VIEW_BOOKS_JSP = JSP_BASE_DIR + "books.jsp";

    public static final String UPLOAD_DIR = "/upload";

    //--- attr names
    public static final String ATTR_FILMS = "films";
    public static final String ATTR_BOOKS = "books";

    public static final String FILMS_ATTR = "films";
    public static final String BOOKS_ATTR = "books";


    //--- actions
    public static final String ACTION_MAIN = "index.html";
    public static final String ACTION_BOOKS = "books";
    public static final String ACTION_FILMS = "films";
    public static final String ACTION_LOGIN = "login";

    public static final String[] ALLOWABLE_ACTION = new String[]{
            ACTION_MAIN,
            ACTION_BOOKS,
            ACTION_FILMS,
            ACTION_LOGIN
    };
}
