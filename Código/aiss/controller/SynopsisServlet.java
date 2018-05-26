package aiss.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aiss.model.igdb.Game;
import aiss.resources.IGDBResource;

public class SynopsisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public SynopsisServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion  = request.getSession();
		String id = (String)sesion.getAttribute("id");
		sesion.setAttribute("servlet", "synopsis");
		IGDBResource igdb = new IGDBResource();
		List<Game> igdbResults = igdb.getGameId(id);
	    if(igdbResults!=null) {
			if (igdbResults.get(0).getEsrb()==null) {
				sesion.setAttribute("synopsis", "The synopsis doesn't exist");
			} else if(igdbResults.get(0).getEsrb().getSynopsis()==null || igdbResults.get(0).getEsrb().getSynopsis().equals("")) {
				sesion.setAttribute("synopsis", "The synopsis doesn't exist");
			}else {
				sesion.setAttribute("synopsis", igdbResults.get(0).getEsrb().getSynopsis());
			}
	    }
		request.getRequestDispatcher("/synopsis.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}