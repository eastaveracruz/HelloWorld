package edu.films.controller;

import edu.films.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

import static edu.films.controller.WEB_CONSTANTS.ACTION_MAIN;
import static edu.films.controller.WEB_CONSTANTS.ALLOWABLE_ACTION;

/**
 *
 */
//TODO extract const
@WebServlet("login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("logout".equalsIgnoreCase(req.getParameter("logout"))) {
            req.getSession().removeAttribute("currentUser");
        }
        String action = getRedirectAction(req, ACTION_MAIN);
        resp.sendRedirect(action);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        String pass = req.getParameter("pass");
        if (passwordMatch(user, pass)) {
            req.getSession().setAttribute("currentUser", new User(user));
            String action = getRedirectAction(req, WEB_CONSTANTS.ACTION_FILMS);
            resp.sendRedirect(action);
        } else {
            String pageName = "/films";
            RequestDispatcher dispatcher = req.getRequestDispatcher(pageName);
            req.setAttribute("message", "Unable to login. Please try again!!!");
            dispatcher.forward(req, resp);
        }
    }

    private String getRedirectAction(HttpServletRequest req, String action) {
        String parameterAction = req.getParameter("action");
        if (validateAction(parameterAction)) {
            action = parameterAction;
        }
        return action;
    }

    private boolean validateAction(String parameterAction) {
        boolean valueLength = parameterAction != null && parameterAction.length() > 0;
        if (!valueLength){
            return valueLength;
        }
        return Arrays.asList(ALLOWABLE_ACTION).contains(parameterAction);
    }

    private boolean passwordMatch(String user, String pass) {
        return true;
    }
}
