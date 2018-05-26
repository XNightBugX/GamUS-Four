package aiss.resources;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.restlet.data.Header;
import org.restlet.engine.header.HeaderConstants;
import org.restlet.resource.ClientResource;
import org.restlet.util.Series;

import aiss.model.igdb.Game;
import aiss.model.igdb.Genre;

@Path("/games")
public class IGDBResource {
	
	private static final String IGDB_API_KEY = "0a4848dddc9b4adb3943d0db7d503eaf";
	private static final Logger log = Logger.getLogger(IGDBResource.class.getName());
	public static IGDBResource _instance=null;

	public static IGDBResource getInstance() {
		if(_instance==null) {
			_instance=new IGDBResource();
		}
		return _instance; 
	}
	
	public List<Game> getGame(String query) throws IOException {
		String game = URLEncoder.encode(query, "UTF-8");
		game.replace(" ", "+");
		String uri = "https://api-2445582011268.apicast.io/games/?search=" + game + "&fields=name,platforms,genres,cover,esrb,rating,pegi,summary&filter[version_parent][not_exists]=1";
		ClientResource cr = new ClientResource(uri);
		addHeader(cr, "user-key", IGDB_API_KEY);
		Game[] igdb = cr.get(Game[].class);
		log.log(Level.INFO, "IGDBResource: Games that matches with the search are: " + igdb.toString());
		List<Game> listG = new ArrayList<>();
	    
		for (int i = 0; i < igdb.length; i++) {
			listG.add(igdb[i]);
		}
		return listG;
	}
		    
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public List<Game> getGameId(@PathParam("id") String id) throws IOException {
	    String uri = "https://api-2445582011268.apicast.io/games/" + id + "?fields=name,platforms,genres,cover,esrb,rating,pegi,summary"; 
	    ClientResource cr = new ClientResource(uri);
	    addHeader(cr, "user-key", IGDB_API_KEY);
	    Game[] igdb = cr.get(Game[].class);
	    log.log(Level.INFO, "Games are: " + igdb.toString());
	    List<Game> listG = new ArrayList<>();
	    
	    for (int i = 0; i < igdb.length; i++) {
		    listG.add(igdb[i]);
		 }
		    return listG;
	  }
		  
	@GET
	@Path("/{genres}&{name}")
	@Produces("application/json")
	public List<Integer> getGameGenre(@PathParam("genres")String generos, @PathParam("name")String query) throws IOException {
		List<Genre> listGen = new ArrayList<>();
		String gen1 = generos.replace("[", "");
		String gen2 = gen1.replace("]", "");
		String gen3 = gen2.replace(" ", "");
		String uri = "https://api-2445582011268.apicast.io/genres/" + gen3 + "?fields=games";
		ClientResource cr = new ClientResource(uri);
		addHeader(cr, "user-key", IGDB_API_KEY);
		Genre[] igdbClass = cr.get(Genre[].class);
		log.log(Level.INFO, "Game vale " + igdbClass);
	    
		for (int i = 0; i < igdbClass.length; i++) {
			listGen.add(igdbClass[i]);
		}
		List<Integer> li = listGen.get(0).getGames();
		Integer a = ThreadLocalRandom.current().nextInt(5, li.size()-10);
		Integer b = a + 3;
		return li.subList(li.size()-b, li.size()-a);
	}
  
	public void addHeader(ClientResource cr, String headerName, String headerValue) {
		@SuppressWarnings("unchecked")
		Series<Header> headers = (Series<Header>) cr.getRequest().getAttributes().get(HeaderConstants.ATTRIBUTE_HEADERS);
			if (headers == null) {
					headers = new Series<Header>(Header.class);
					cr.getRequest().getAttributes().put(HeaderConstants.ATTRIBUTE_HEADERS, headers);
			}
		headers.add(headerName, headerValue);
	}
}