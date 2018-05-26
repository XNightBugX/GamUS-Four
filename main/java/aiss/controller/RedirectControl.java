package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RedirectControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log=Logger.getLogger(RedirectControl.class.getName());
       
    public RedirectControl() {
        super();
     }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String s = (String) request.getSession().getAttribute("servlet");
	if(s.equals("main")) {
		log.log(Level.INFO,"RedirectControl: redirecting to Main");
		response.sendRedirect("/main.jsp");
	}else if(s.equals("trailer")) {
		log.log(Level.INFO,"RedirectControl: redirecting to Trailer");
		response.sendRedirect("/trailer.jsp");
	}else if(s.equals("synopsis")) {
		log.log(Level.INFO,"RedirectControl: redirecting to Synopsis");
		response.sendRedirect("/synopsis.jsp");
	}else {
		response.sendRedirect("/error.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}