package aiss.resources;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.restlet.resource.ClientResource;
import aiss.model.blogger.Blogger;

public class BloggerResource {

private static final Logger log=Logger.getLogger(BloggerResource.class.getName());
	
	private String uri = "https://www.googleapis.com/blogger/v3/blogs/5307660914626103021/posts";
	private String access_token;
	
	public BloggerResource(String access_token) {
		this.access_token = access_token;
	}
	
	public boolean publishPost(String message){
		boolean res = true;
		Blogger a = new Blogger();
		ClientResource cr=new ClientResource(uri+"?access_token="+access_token);
		a.setTitle("GamUS Four");
		a.setContent(message);
		try{
			cr.post(a);
			log.log(Level.INFO, "BloggerResource: See your blog :D");
		}catch(Exception e) {
			log.log(Level.WARNING, "An error ocurred ", e.getMessage());
			res = false;
		}
		return res;
	}
}