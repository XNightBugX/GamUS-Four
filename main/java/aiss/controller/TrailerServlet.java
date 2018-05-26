package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aiss.model.youtube.search.Youtube;
import aiss.resources.YoutubeResource;

public class TrailerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log  =Logger.getLogger(TrailerServlet.class.getName());    
 
    public TrailerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("servlet", "trailer");
		String query = (String) session.getAttribute("name");
	    YoutubeResource video = new YoutubeResource();
	    Youtube results = video.getTrailer(query);			
	    	
	    if(results.getItems().isEmpty()) {
	    	log.log(Level.INFO,"TrailerServlet: The search is empty");
	    	session.setAttribute("videos", "QH2-TGUlwu4");
	    	request.getRequestDispatcher("/trailer.jsp").forward(request, response);
	    }else {
	    	log.log(Level.INFO,"TrailerServlet: The video ID is: " + results.getItems().get(0).getId().getVideoId().toString());
	    	session.setAttribute("videos", results.getItems().get(0).getId().getVideoId().toString());
	    	request.getRequestDispatcher("/trailer.jsp").forward(request, response);
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}