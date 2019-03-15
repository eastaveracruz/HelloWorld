package test.training.games;

public interface IDeveloper {
	String mName = null;
	/**
	 * getter for Developer Name
	 * @return String the Developer name
	 */
	public abstract String getName();

	/**
	 * setter for Developer Name
	 */
	public abstract void setName(String mName);

}
