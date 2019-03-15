package test.training.login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class Login
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String USER_NAME = "userName";
	private static final String PASSWORD = "password";
	//private static final String FLAG = "flag";
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		String userName = request.getParameter(USER_NAME);
		String password = request.getParameter(PASSWORD);
                // TODO extract to logic class
		if (userName != null || password != null) {
			if (userName.equals("user1")&&password.equals("user1")) {
					HttpSession session = request.getSession(true);	    
					session.setAttribute("currentSessionUser",userName); 
					response.sendRedirect("home.jsp"); 
			}
			else {
				String pageName = "login.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(pageName);
				request.setAttribute("message", "Unable to login. Please try again!!!");
				dispatcher.forward(request, response);
			}			 
		}
		
		
	}

}
