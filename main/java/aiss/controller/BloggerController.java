package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import aiss.resources.BloggerResource;

public class BloggerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(BloggerController.class.getName()); 
   
	public BloggerController() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	String accessToken=(String)request.getSession().getAttribute("Blogger-token");
		String publicacion = request.getParameter("publicacion");
		RequestDispatcher rd = null;
		if(accessToken!=null && !"".equals(accessToken)){
			BloggerResource bResource=new BloggerResource(accessToken);
			if(publicacion!=null) {
			bResource.publishPost(publicacion);
			log.log(Level.INFO,"BloggerController: Post sended, redirecting you to the page that send the post request");
			rd = request.getRequestDispatcher("/RedirectControl");
			}else {
			log.log(Level.WARNING, "BloggerController: An error ocurred");
			rd = request.getRequestDispatcher("/bloggerpost.jsp");
			}
			rd.forward(request, response);
		}else{
			log.info("Trying to access to Blogger without an Access Token, redirecting to OAuth2 servlet");
			request.getRequestDispatcher("/AuthController/Blogger").forward(request,response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}
}