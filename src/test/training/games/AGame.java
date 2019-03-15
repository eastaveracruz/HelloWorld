package test.training.games;

import java.util.ArrayList;
import java.util.Date;

public abstract class AGame {
	String mName = null;
	Date mDate = null;
	Genre mGenre = null;
	Developer mDeveloper = null;
	ArrayList  <Platform> mSupportedPlatforms = null;
	
	/**
	 * getter for Game Name
	 * @return String the game name
	 */
	public abstract String getName();

	/**
	 * setter for Game Name
	 */
	public abstract void setName(String mName);

	/**
	 * getter for Date when game has been added
	 * @return Date
	 */
	public abstract Date getDate();

	/**
	 * setter for Date when game has been added
	 */
	public abstract void setDate(Date mDate);

	/**
	 * getter for Genre to which the game is related
	 * @return Genre
	 */
	public abstract Genre getGenre();

	/**
	 * setter for Genre to which the game is related
	 */
	public abstract void setGenre(Genre mGenre);

	/**
	 * getter for Developer of the game
	 * @return Developer
	 */
	public abstract Developer getDeveloper();

	/**
	 * setter for Developer of the game
	 */
	public abstract void setDeveloper(Developer mDeveloper);

	/**
	 * getter for supported platforms for the game
	 * @return ArrayList<Platform>
	 */
	public abstract ArrayList<Platform> getSupportedPlatforms();

	/**
	 * setter for supported platforms for the game
	 */
	public abstract void setSupportedPlatforms(ArrayList<Platform> mSupportedPlatforms);
	
}
