package test.training.games;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//TODO rename and split files to packages:  web, data, bussness
/**
 * Servlet implementation class Games
 */
//FIXME rename to understandible name
public class Games extends HttpServlet {
	
	private static final String GAMES_LIST_OBJ = "gamesListObj";

	private static final long serialVersionUID = 1L;

	private GamesList mGamesList;
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//TODO extract method or etract basic serblet class 
		Object gamesListObj = getServletContext().getAttribute(GAMES_LIST_OBJ);
		if (gamesListObj == null){
			mGamesList = new GamesList();
			getServletContext().setAttribute(GAMES_LIST_OBJ, mGamesList);
		}
		else mGamesList = (GamesList) gamesListObj;
	}
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
		String pageName = "/global/games.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(pageName);

		getServletContext().setAttribute("gameList", mGamesList.getGamesList());
		dispatcher.forward(request, response);
		
		
	}

}
