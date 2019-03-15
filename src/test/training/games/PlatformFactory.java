package test.training.games;

import java.util.ArrayList;

public class PlatformFactory {

	public static ArrayList<Platform> genreFactoryMethod(ArrayList<String> pSupportedPlatforms) {
		if (pSupportedPlatforms == null) return null;
		ArrayList<Platform> platforms = new ArrayList<Platform>() ;
		for (String platformAsString : pSupportedPlatforms ) {
			Platform platform = null;
			if (platformAsString.equals("PC")) {
				platform = new PC ();
			} else {
				if (platformAsString.equals("XBox360")){
					platform = new XBox360 ();
				}
				else {
					if (platformAsString.equals("PS3" )) {
						platform = new PS3 ();
					}
				}
			}
			if (platform != null)platforms.add(platform);
		}
				
		return platforms;
	}

}
