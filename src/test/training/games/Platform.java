package test.training.games;

public abstract class Platform {
	

	public String mName;

	public Platform(String pName) {
		mName = pName;
	}

	@Override
	public String toString() {
		return mName;

	}
}
