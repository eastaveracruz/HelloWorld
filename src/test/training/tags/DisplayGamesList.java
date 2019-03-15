package test.training.tags;

import test.training.games.Game;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import java.io.IOException;
import java.util.ArrayList;

public class DisplayGamesList implements Tag {
	
	private PageContext mPageContext = null;
	private Tag mParent = null;
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

	@SuppressWarnings("unchecked")
	public int doStartTag() throws JspException {
		try {
			JspWriter out = mPageContext.getOut();
            //HttpServletResponse response = (HttpServletResponse)mPageContext.getResponse();
			//out.println(this.gamesList+"22222");
			out.println ("<table class='showGamesTable'>");
			out.println ("<tr class='showGamesHeader'>");
			out.println ("<th>Number</th>");
			out.println ("<th>Game Name</th>");
			out.println ("<th>Genre</th>");
			out.println ("<th>Developer</th>");
			out.println ("<th>Supported Platforms</th>");
			out.println ("<th>Date</th>");
			out.println ("</tr>");
			ArrayList <Game> games = (ArrayList<Game>) mPageContext.getServletContext().getAttribute("gameList");
			for (int i=1; i<=games.size();i++){
				Game game = games.get(i-1);
				out.println ("<tr class='showGamesRow'>");
				out.println ("<td class='showGamesCell'>"+i+"</td>");
				out.println ("<td class='showGamesCell'>"+game.getName()+"</td>");
				if (game.getGenre() != null) out.println ("<td>"+game.getGenre()+"</td>");
				else out.println ("<td class='showGamesCell'>No Info</td>");
				if (game.getDeveloper()!=null) out.println ("<td>"+game.getDeveloper()+"</td>");
				else out.println ("<td class='showGamesCell'>No Info</td>");
				if (game.getSupportedPlatformsAsString()!=null) out.println ("<td>"+game.getSupportedPlatformsAsString()+"</td>");
				else out.println ("<td class='showGamesCell'>No Info</td>");
				if (game.getDate()!=null) out.println ("<td>"+game.getDate()+"</td>");
				else out.println ("<td class='showGamesCell'>No Info</td>");
				out.println ("</tr>");
			}
			out.println ("</table>");
			
			
		}
		catch (IOException e) {
			System.out.println("Unable to display games list"+e.getMessage());
			e.printStackTrace();
		}
		
		return SKIP_BODY;
	}

	public Tag getParent() {
		return mParent;
	}

	public void release() {
		mPageContext = null;
		mParent = null;
		
	}

	public void setPageContext(PageContext pPageContext) {
		mPageContext = pPageContext;
		
	}

	public void setParent(Tag pTag) {
		mParent = pTag;
		
	}

}
