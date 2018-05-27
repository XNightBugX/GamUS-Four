package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import aiss.resources.BloggerResource;

public class BloggerTest {
	@Test
	public void testBlogger() {
	//PRIMERO HAY QUE HACER UNA LLAMADA A GOOGLE NORMAL, PARA QUE SE GUARDE EL ACCESS TOKEN Y ENTONCES LA PRUEBA DE TRUE
	String posting = "Prueba";
	String accessToken = "ya29.Glu8BUfgBrzYcw-DZP9Isa8O97V6JJKX3ocYZY7pTIYc9wBQKpiFGc637a7gJRDXY_c1LgyKY7CGALsTJ9F51OoPTBYj_r2RDZomKgjIBX_YRoI0sa4bJRJiqgmY";
	BloggerResource blog = new BloggerResource(accessToken);
	boolean post = blog.publishPost(posting);
		if(post == false) {
	assertFalse("Unable to post", post);
		}else {
	assertTrue("Successful post", post);
		}
	}
}