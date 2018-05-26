package test;


import static org.junit.Assert.assertNotNull;
import java.io.IOException;
import java.util.List;

import org.junit.Test;
import aiss.model.igdb.Game;
import aiss.resources.IGDBResource;

public class IGDBTest {

	@Test
	public void getGameTest() throws  IOException {
		String name = "Ni No Kuni II";
		IGDBResource game = new IGDBResource();
		List<Game> igdbResults = game.getGame(name);	
		List<Integer> igdbGeneros = game.getGameGenre("[12, 16]", igdbResults.get(0).getName());
		
		for (Integer genre : igdbGeneros) {
				List<Game> asdf = game.getGameId(genre.toString());
				System.out.println(asdf.get(0).getName());
			}
		
		assertNotNull("La búsqueda no es null", igdbResults);

		System.out.println("Título de juego "+  igdbResults.get(0).getName());

		System.out.println(game.getGameId("7").get(0).getName());
	}		
}