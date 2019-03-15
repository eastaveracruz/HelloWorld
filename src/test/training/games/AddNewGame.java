package test.training.games;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddNewGame
 */
public class AddNewGame extends HttpServlet {
	private GamesList mGamesList;
	private static final long serialVersionUID = 1L;
	private static final String GAME_NAME = "name";
	private static final String GAME_GENRE = "genre";
	private static final String GAME_DEVELOPER = "developer";
	private static final String GAME_PLATFORM_PC = "pc";
	private static final String GAME_PLATFORM_XBOX = "xbox";
	private static final String GAME_PLATFORM_PS = "ps";
	private static final String GAMES_LIST_OBJ = "gamesListObj";
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
                //TODO extract to Factory
		mGamesList = new GamesList();
		Object gamesListObj = getServletContext().getAttribute(GAMES_LIST_OBJ);
		if (gamesListObj == null){
			mGamesList = new GamesList();
			getServletContext().setAttribute(GAMES_LIST_OBJ, mGamesList);
		}
		else mGamesList = (GamesList) gamesListObj;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String pageName = "/global/games.jsp";
		ArrayList <String> platforms = new ArrayList<String> ();
		String name = request.getParameter(GAME_NAME);
		String genre = request.getParameter(GAME_GENRE);
		String developer = request.getParameter(GAME_DEVELOPER);
		String pc = request.getParameter(GAME_PLATFORM_PC);
		if (pc!=null) platforms.add(pc);
		String xbox = request.getParameter(GAME_PLATFORM_XBOX);
		if (xbox!=null) platforms.add(xbox);
		String ps = request.getParameter(GAME_PLATFORM_PS);
		if (ps!=null) platforms.add(ps);
		
		mGamesList.addGame(name, genre, developer, platforms);

		RequestDispatcher dispatcher = request.getRequestDispatcher(pageName);
		getServletContext().setAttribute("gameList", mGamesList.getGamesList());
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}