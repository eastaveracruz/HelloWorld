package test.training.games;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FindGames
 */
public class FindGames extends HttpServlet {
//TODO rename GameList class and field too
	private GamesList mGamesList;
	private static final long serialVersionUID = 1L;
	private static final String GAME_NAME_TO_SEARCH = "name";
	private static final String GAMES_LIST_OBJ = "gamesListObj";
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		mGamesList = new GamesList();
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
		response.setContentType("text/html"); 
		String pageName = "/global/games.jsp";
		String name = request.getParameter(GAME_NAME_TO_SEARCH);
		RequestDispatcher dispatcher = request.getRequestDispatcher(pageName);
		if (name != null)getServletContext().setAttribute("gameList", mGamesList.findGames(name));
		else request.setAttribute("gameList", mGamesList.getGamesList());
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
