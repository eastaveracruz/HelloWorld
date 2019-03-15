package test.training.user;

/**
 * implementation of class UserProfile
 */
public class UserProfile {
	private static final String USER1_LOGIN = "user1";
	private static final String USER1_NAME = "Aliaksei";
	private static final long serialVersionUID = 1L;
	private String mUserName = "Sieger";
	private String mEmail = "nsieger@tut.by";
	private String mPosition = "Lead Software Testing Engineer";
	private int mAge = 25;

		/**
		 * sets user name
		 * @param value
		 */
	    public void setUsername(String pValue )
	    {
	    	if (pValue.equals(USER1_LOGIN)) this.mUserName = USER1_NAME ;
	    	else mUserName = pValue;
	    }
	    
	    /**
	     * sets email
	     * @param pValue
	     */
	    public void setEmail( String pValue )
	    {
	        mEmail = pValue;
	    }
	    
	    /**
	     * sets Age
	     * @param pValue
	     */
	    public void setAge( int pValue)
	    {
	        mAge = pValue;
	    }

	    /**
	     * getter for name;
	     * @return
	     */
	    public String getUsername() { 
	    	return mUserName; 
	    }

	    public String getEmail() {
	    	return mEmail; 
	    }

	    public int getAge() { 
	    	return mAge;
	    }

	    /**
	     * sets Position
	     * @param mPosition
	     */
		public void setPosition(String pPosition) {
			this.mPosition = pPosition;
		}

		/**
		 * getter for Position
		 * @return String position in the company
		 */
		public String getPosition() {
			return mPosition;
		}
}
