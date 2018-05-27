package test;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;


import org.junit.Test;



import aiss.resources.YoutubeResource;


public class YoutubeTest {
	
	@Test
	public void getGamesTest() throws IOException {
		String name = "Ni no Kuni";
		YoutubeResource video = new YoutubeResource();
		String igdbResults = video.getTrailer(name).getItems().get(0).getId().getVideoId();
		
		assertNotNull("La búsqueda es null", igdbResults);
		
		System.out.println("El id del video es " + igdbResults);
	}
}