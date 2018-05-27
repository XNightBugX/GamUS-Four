package aiss.resources;

import java.io.UnsupportedEncodingException;

import java.net.URLEncoder;
import org.restlet.resource.ClientResource;
import aiss.model.youtube.search.Youtube;

public class YoutubeResource {
	public static YoutubeResource _instance=null;
	private static final String YOUTUBE_API_KEY = "AIzaSyBsRTBsLC8ThJrRETWJHZom31r3hh20nd0";
	
	public static YoutubeResource getInstance() {
		if(_instance==null) {
			_instance=new YoutubeResource();
		}
		return _instance; 
	} 
	
	public Youtube getTrailer(String query) throws UnsupportedEncodingException {
		String search = URLEncoder.encode(query, "UTF-8");
		String uri = "https://www.googleapis.com/youtube/v3/search?part=id&channelId=UCKy1dAqELo0zrOtPkf0eTMw&maxResults=1&q=" + search + "&key=" + YOUTUBE_API_KEY;
		ClientResource cr = new ClientResource(uri);
		Youtube youtubeSearch = cr.get(Youtube.class);		
		return youtubeSearch;
	}
}