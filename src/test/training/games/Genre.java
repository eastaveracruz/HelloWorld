package test.training.games;

public abstract class Genre {
	
	public String mName;
	
	public Genre(String pName) {
		mName = pName;
	}

	@Override
	public String toString () {    
		return mName;
		
	}
}
