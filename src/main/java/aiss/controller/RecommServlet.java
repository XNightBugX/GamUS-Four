package aiss.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.igdb.Game;
import aiss.resources.IGDBResource;

public class RecommServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(RecommServlet.class.getName());
       
    public RecommServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = request.getParameter("name");
		String genres = request.getParameter("recomm");
		log.log(Level.INFO,"RecommServlet: Trying to search games with the same genre");
		IGDBResource igdb = new IGDBResource();
		List<Game> listG = new ArrayList<>();
		List<Game> listFin = new ArrayList<>();
		List<Integer> igdbGenres = igdb.getGameGenre(genres, query);
		
			for (Integer juegoId : igdbGenres) {
				listG = igdb.getGameId(juegoId.toString());
				Game gameadd = listG.get(0);
				listFin.add(gameadd);
			}
			
		RequestDispatcher rd = null;
			if(!(listFin.isEmpty())) {
				request.setAttribute("game", listFin);
				request.setAttribute("name", query);
				rd = request.getRequestDispatcher("/recomm.jsp");
			}else {
				log.log(Level.WARNING, "RecommServlet: An error ocurred");
				rd = request.getRequestDispatcher("/error.jsp");
			}
			rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}