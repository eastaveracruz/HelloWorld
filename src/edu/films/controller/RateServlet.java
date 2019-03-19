package edu.films.controller;

import edu.films.model.User;
import edu.films.service.RatingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 */
@WebServlet("/rate")
public class RateServlet extends HttpServlet {

    private RatingService ratingService = RatingService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //TODO NPE
        String act = req.getParameter("action");
        String id = req.getParameter("id").replace("\t", "");
        String rating = req.getParameter("rating");

        String action = getRedirectAction(req, WEB_CONSTANTS.ACTION_MAIN);
        //TODO make model
        Object currentUser = req.getSession().getAttribute("currentUser");
        // TODO if not user

        boolean result = false;
        switch (act) {
            case "films":
                result = ratingService.rateFilm((User) currentUser, id, rating);
                break;
            case "books":
                result = ratingService.rateBook((User) currentUser, id, rating);
                break;
        }

        String fullAction = action + (result ? "" : "?message='error happened'");
        resp.sendRedirect(fullAction);
    }

    //TODO copypaste
    private String getRedirectAction(HttpServletRequest req, String action) {
        String parameterAction = req.getParameter("action");
        if (validateAction(parameterAction)) {
            action = parameterAction;
        }
        return action;
    }

    //TODO copypaste
    private boolean validateAction(String parameterAction) {
        //TODO validate action to correct one
        return parameterAction != null && parameterAction.length() > 0;
    }
}
