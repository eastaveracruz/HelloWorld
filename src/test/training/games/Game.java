package test.training.games;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Game extends AGame {
	private static final String COMMA = ", ";
	String mName;
	Date mDate;
	Genre mGenre;
	Developer mDeveloper;
	ArrayList  <Platform> mSupportedPlatforms;
	
	public Game (String pName) {
		setName(pName);
	}
	
	/**
	 * @see test.training.games.IGame1#getMName()
	 */
	public String getName() {
		return mName;
	}
	/**
	 * @see test.training.games.IGame1#setMName(java.lang.String)
	 */
	public void setName(String pName) {
		mName = pName;
	}
	/**
	 * @see test.training.games.IGame1#getMDate()
	 */
	public Date getDate() {
		return mDate;
	}
	/**
	 * @see test.training.games.IGame1#setMDate(java.util.Date)
	 */
	public void setDate(Date pDate) {
		mDate = pDate;
	}
	/**
	 * @see test.training.games.IGame1#getMGenre()
	 */
	public Genre getGenre() {
		return mGenre;
	}
	/**
	 * @see test.training.games.IGame1#setMGenre(test.training.games.Genre)
	 */
	public void setGenre(Genre pGenre) {
		mGenre = pGenre;
	}
	/**
	 * @see test.training.games.IGame1#getMDeveloper()
	 */
	public Developer getDeveloper() {
		return mDeveloper;
	}
	/**
	 * @see test.training.games.IGame1#setMDeveloper(test.training.games.Developer)
	 */
	public void setDeveloper(Developer pDeveloper) {
		mDeveloper = pDeveloper;
	}
	/**
	 * @see test.training.games.IGame1#getMSupportedPlatforms()
	 */
	public ArrayList<Platform> getSupportedPlatforms() {
		return mSupportedPlatforms;
	}
	/** 
	 * @see test.training.games.IGame1#setMSupportedPlatforms(java.util.ArrayList)
	 */
	public void setSupportedPlatforms(ArrayList<Platform> pSupportedPlatforms) {
		mSupportedPlatforms = pSupportedPlatforms;
	}
	
	@Override
	public String toString () {
		//adding name
		String gameAsString = "Game:" + mName + COMMA;
	   
	    //adding genre
		gameAsString = gameAsString+"Genre: "+mGenre + COMMA; 
	    
	    //adding platform
		gameAsString =  (mSupportedPlatforms != null && !mSupportedPlatforms.isEmpty() ? gameAsString
				+ "Platforms: "+mSupportedPlatforms : gameAsString)	+ COMMA;
	    
	    //adding Developer
		gameAsString = gameAsString+"Developer: "+mDeveloper;
	    
		return gameAsString;
		
	}

	public String getSupportedPlatformsAsString() {
		String supportedPlatformsAsString = null;
		if (mSupportedPlatforms == null || mSupportedPlatforms.isEmpty()) return null;
		Iterator<Platform> it = mSupportedPlatforms.iterator();
		while (it.hasNext()) {
			Platform platform = it.next();
			if (supportedPlatformsAsString != null)supportedPlatformsAsString = supportedPlatformsAsString+platform.toString();
			else supportedPlatformsAsString= platform.toString();
			if (it.hasNext()) supportedPlatformsAsString = supportedPlatformsAsString+ COMMA;
		}
		return supportedPlatformsAsString;
	}
	
}
