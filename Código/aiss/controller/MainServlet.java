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
    	HttpSession sesion = request.getSession();
    	eliminaSesion(sesion);
    	String id = request.getParameter("id");
    	sesion.setAttribute("servlet", "main");
    	log.log(Level.INFO, "MainServlet: The search game`s ID is: " + id);
		IGDBResource igdb = new IGDBResource();
		List<Game> igdbResults = igdb.getGameId(id);
		RequestDispatcher rd = null;
			if(!(igdbResults == null)) {
		        sesion.setAttribute("name", igdbResults.get(0).getName());
		        sesion.setAttribute("GAME", igdbResults.get(0).getName().replace(" ", "-"));
		        sesion.setAttribute("amazon", igdbResults.get(0).getName().replace(" ", "+"));
		        sesion.setAttribute("steam", igdbResults.get(0).getName().replace(" ", "+"));
		        sesion.setAttribute("g2a", igdbResults.get(0).getName().replace(" ", "+"));
				if(igdbResults.get(0).getCover()==null) {
				sesion.setAttribute("img", "//i.imgur.com/aJBVL2V.png");	

				}else {
				sesion.setAttribute("img", igdbResults.get(0).getCover().getUrl().replace("thumb", "cover_big"));
				}
				if(igdbResults.get(0).getPegi()==null) {
				sesion.setAttribute("pegi", "No pegi");
				}else {
					Integer pegii = igdbResults.get(0).getPegi().getRating();
					sesion.setAttribute("pegi", Game.createPegi(pegii));
					sesion.setAttribute("pegi2", igdbResults.get(0).getPegi().getRating());
				}
				if(igdbResults.get(0).getGenres()==null) {
					sesion.setAttribute("genres", "No genre");
				}else {
					List<Integer> generos = igdbResults.get(0).getGenres();
					sesion.setAttribute("genres", Game.createGenre(generos));
					sesion.setAttribute("recomm", generos);
				}
				if(igdbResults.get(0).getPlatforms()==null) {
					sesion.setAttribute("platform", "No platforms");
				}else {
					List<Integer> plataformas = igdbResults.get(0).getPlatforms();
					sesion.setAttribute("platform", Game.createPlatform(plataformas));
				}
				if(igdbResults.get(0).getRating()==null) {
					sesion.setAttribute("rating", "No rating");
				}else {
					sesion.setAttribute("rating", igdbResults.get(0).getRating().intValue());
				}
				sesion.setAttribute("id", id);
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

	private void eliminaSesion(HttpSession sesion) {
		sesion.removeAttribute("name");
		sesion.removeAttribute("GAME");
		sesion.removeAttribute("amazon");
		sesion.removeAttribute("steam");
		sesion.removeAttribute("g2a");
		sesion.removeAttribute("img");
		sesion.removeAttribute("pegi");
		sesion.removeAttribute("pegi2");
		sesion.removeAttribute("genres");
		sesion.removeAttribute("recomm");
		sesion.removeAttribute("platform");
		sesion.removeAttribute("rating");
		sesion.removeAttribute("synopsis");
		sesion.removeAttribute("id");
	}
}