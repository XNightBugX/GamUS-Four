package aiss.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aiss.model.igdb.Game;
import aiss.resources.IGDBResource;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(MainServlet.class.getName());
       
    public MainServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	eliminaSession(session);
    	String id = request.getParameter("id");
    	session.setAttribute("servlet", "main");
    	log.log(Level.INFO, "MainServlet: The search game`s ID is: " + id);
		IGDBResource igdb = new IGDBResource();
		List<Game> igdbResults = igdb.getGameId(id);
		RequestDispatcher rd = null;
			if(!(igdbResults == null)) {
		        session.setAttribute("name", igdbResults.get(0).getName());
		        session.setAttribute("GAME", igdbResults.get(0).getName().replace(" ", "-"));
		        session.setAttribute("amazon", igdbResults.get(0).getName().replace(" ", "+"));
		        session.setAttribute("steam", igdbResults.get(0).getName().replace(" ", "+"));
		        session.setAttribute("g2a", igdbResults.get(0).getName().replace(" ", "+"));
				if(igdbResults.get(0).getCover()==null) {
				session.setAttribute("img", "//i.imgur.com/aJBVL2V.png");	

				}else {
				session.setAttribute("img", igdbResults.get(0).getCover().getUrl().replace("thumb", "cover_big"));
				}
				if(igdbResults.get(0).getPegi()==null) {
				session.setAttribute("pegi", "No pegi");
				}else {
					Integer pegii = igdbResults.get(0).getPegi().getRating();
					session.setAttribute("pegi", Game.createPegi(pegii));
					session.setAttribute("pegi2", igdbResults.get(0).getPegi().getRating());
				}
				if(igdbResults.get(0).getGenres()==null) {
					session.setAttribute("genres", "No genre");
				}else {
					List<Integer> generos = igdbResults.get(0).getGenres();
					session.setAttribute("genres", Game.createGenre(generos));
					session.setAttribute("recomm", generos);
				}
				if(igdbResults.get(0).getPlatforms()==null) {
					session.setAttribute("platform", "No platforms");
				}else {
					List<Integer> plataformas = igdbResults.get(0).getPlatforms();
					session.setAttribute("platform", Game.createPlatform(plataformas));
				}
				if(igdbResults.get(0).getRating()==null) {
					session.setAttribute("rating", "No rating");
				}else {
					session.setAttribute("rating", igdbResults.get(0).getRating().intValue());
				}
				session.setAttribute("id", id);
				rd = request.getRequestDispatcher("/main.jsp");
			}else {
				log.log(Level.SEVERE, "MainServlet: An error ocurred");
				rd = request.getRequestDispatcher("/error.jsp");
			}
			rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void eliminaSession(HttpSession session) {
		session.removeAttribute("name");
		session.removeAttribute("GAME");
		session.removeAttribute("amazon");
		session.removeAttribute("steam");
		session.removeAttribute("g2a");
		session.removeAttribute("img");
		session.removeAttribute("pegi");
		session.removeAttribute("pegi2");
		session.removeAttribute("genres");
		session.removeAttribute("recomm");
		session.removeAttribute("platform");
		session.removeAttribute("rating");
		session.removeAttribute("synopsis");
		session.removeAttribute("id");
	}
}