package test.training.games;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

//TODO extract interface
//TODO  create DB realization 
//TODO create JUnit test for it
public class GamesList{
	
	private ArrayList<Game> mGamesList;
	
	
	public GamesList() {
		mGamesList = new ArrayList<Game> ();
		mGamesList.add(new Game ("Mass Effect 3"));
		mGamesList.add(new Game ("Dishonored"));
		mGamesList.add(new Game ("Batman: Arkham City"));
		mGamesList.add(new Game ("Civilization 5"));
		mGamesList.add(new Game ("Quake 3"));
	}

	public ArrayList<Game> getGamesList() {
		return mGamesList;
	}

/*	public void setGamesList(ArrayList<Game> pGamesList) {
		mGamesList = pGamesList;
	}*/

	public void addGame(String pName, String pGenre, String pDeveloper, ArrayList<String> pSupportedPlatforms) {
		Game game = new Game (pName);
		game.setGenre(GenreFactory.genreFactoryMethod (pGenre));
		game.setDeveloper(new Developer(pDeveloper));
		game.setDate(new Date ());
		game.setSupportedPlatforms(PlatformFactory.genreFactoryMethod(pSupportedPlatforms));
		mGamesList.add(game);
	}
	
	public ArrayList<Game> getNewlyAddedGames () {
		ArrayList<Game> newlyAddedGames = new ArrayList<Game> ();
		Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.YEAR, 2012);
		calendar.set(Calendar.MONTH, 10);
		calendar.set(Calendar.DAY_OF_MONTH, 21);
		for (Game game : mGamesList) {
			Date date = game.getDate();
			if (date != null) {
				if (date.after(calendar.getTime()))  {
					newlyAddedGames.add(game);
				}
			}
			
		}
		return newlyAddedGames;
		
	}
	
	public ArrayList<Game> findGames (String pQuery) {
		ArrayList<Game> foundGames = new ArrayList<Game> ();
		for (Game game : mGamesList) {
			String name = game.getName();
			if (name.contains(pQuery)) foundGames.add(game);
		}
		return foundGames;
		
	}
	
	
}
