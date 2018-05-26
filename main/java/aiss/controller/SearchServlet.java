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

import aiss.model.igdb.Game;
import aiss.resources.IGDBResource;

public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(SearchServlet.class.getName());
 
    public SearchServlet() {
        super();
    }

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = request.getParameter("searchQuery");
		IGDBResource igdb = new IGDBResource();
		List<Game> igdbResults = igdb.getGame(query);
		RequestDispatcher rd = null;
			if(!(igdbResults == null)) {
			log.log(Level.INFO, "SearchServlet: The games was: " + igdbResults.toArray().toString());
				request.setAttribute("game", igdbResults);
				rd = request.getRequestDispatcher("/search.jsp");
			}else {
				log.log(Level.WARNING, "SearchServlet: An error ocurred");
				rd = request.getRequestDispatcher("/error.jsp");
			}
			rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}