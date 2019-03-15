package test.training.games;

public class GenreFactory {

	public static Genre genreFactoryMethod(String pGenre) {
		if (pGenre == null) return null;
		Genre genre = null;
		if (pGenre.equals("Action")) {
		 	genre = new Action ();
		} else {
			if (pGenre.equals("RPG")){
				genre = new RPG ();
			}
			else {
				if (pGenre.equals("Shooter" )) {
					genre = new Shooter ();
				}
			}
		}		
		return genre;
	}

}
