package edu.films.web;

import edu.films.controller.WEB_CONSTANTS;

public class CoolDesignRegistryJsp {
    private static final String JSP_DIR = "/jsp";
    //	private static final String DESIGN = JSP_DIR + "/design";
    private static final String DESIGN_COMMON = JSP_DIR + "/common";

    private static final String RESOURCES_DESIGN_DIR = "resources";
    private static final String RESOURCES_CSS_DIR = RESOURCES_DESIGN_DIR + "/css";
    private static final String RESOURCES_IMAGE_DIR = RESOURCES_DESIGN_DIR + "/img";


    public String getJspDir() {
        return JSP_DIR;
    }

    public String getDESIGN() {
        return getJspDir();
    }

    public String getDESIGN_COMMON() {
        return DESIGN_COMMON;
    }


    public String getStyle() {
        return ProjectRegistry.makeUrl(RESOURCES_CSS_DIR);
    }

    public String getImage() {
        return ProjectRegistry.makeUrl(RESOURCES_IMAGE_DIR);
    }

    //------------ ACTIONS
    public String getACTION_MAIN() {
        return ProjectRegistry.makeUrl(WEB_CONSTANTS.ACTION_MAIN);
    }

    public String getACTION_LOGOUT() {
        return ProjectRegistry.makeUrl(WEB_CONSTANTS.ACTION_LOGIN + "?logout=logout");
    }

    public String getACTION_LOGIN() {
        return ProjectRegistry.makeUrl(WEB_CONSTANTS.ACTION_LOGIN);
    }


}
