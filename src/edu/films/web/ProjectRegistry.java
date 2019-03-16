package edu.films.web; /**
 *
 */

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.logging.Logger;


/**
 * Holder of project name
 *
 * @author Artem_Zolotov
 */
public class ProjectRegistry implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {
    private Logger log = Logger.getLogger(ProjectRegistry.class.getName());

    /**
     * must be with '/' before f.ex. '/MBO'
     */
    private static String PROJECT_NAME = "/FavouriteFilms";


    // Public constructor is required by servlet spec
    public ProjectRegistry() {

    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent event) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */

        String contextPath = event.getServletContext().getContextPath();
        log.info("Getting projectName form context. Project name is: " + contextPath);
        PROJECT_NAME = contextPath;
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }

    /**
     * method adds {projectName} before url. It is used instead of <c:url> in
     * order to reduce count scripts in jsp
     */
    public static String makeUrl(String url) {
        String rewrittenUrl = PROJECT_NAME + "/" + url;
        return rewrittenUrl;
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
    }
}
