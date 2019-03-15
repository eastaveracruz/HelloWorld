package test.training.games;

public class Developer implements IDeveloper {
	public String mName;
	
	public Developer(String pDeveloper) {
		setName(pDeveloper);
	}

	public String getName() {
		return mName;
	}

	public void setName(String pName) {
		mName = pName;
	}
	
	@Override
	public String toString () {    
		return mName;
		
		
	}

}
