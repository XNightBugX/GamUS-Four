package aiss.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aiss.model.igdb.Game;

public class MapGameRepository implements GameRepository {
	
	Map<Integer, Game> gameMap;
	private static MapGameRepository instance = null;
	private int index = 0;
	
	public static MapGameRepository getInstance() {
		if (instance==null) {
			instance = new MapGameRepository();
			instance.init();
		}
		return instance;
	}
	
	public void init() {
		gameMap = new HashMap<Integer, Game>();
		
		//List game 1
		List<Integer> l1_g = new ArrayList<>();
		l1_g.add(12);
		
		List<Integer> l1_p = new ArrayList<>();
		l1_p.add(48);
		
		//List game 2
		List<Integer> l2_g = new ArrayList<>();
		l2_g.add(9);
		l2_g.add(15);
		l2_g.add(32);
		
		List<Integer> l2_p = new ArrayList<>();
		l2_p.add(45);
		l2_p.add(6);
		l2_p.add(92);
		l2_p.add(14);
		l2_p.add(48);
		l2_p.add(49);
		l2_p.add(3);
		l2_p.add(130);
		
		//List game 3
		List<Integer> l3_g = new ArrayList<>();
		l3_g.add(9);
		l3_g.add(31);
		
		List<Integer> l3_p = new ArrayList<>();
		l3_p.add(20);
		l3_p.add(55);
		
		//List game 4
		List<Integer> l4_g = new ArrayList<>();
		l4_g.add(8);
		l4_g.add(9);
		l4_g.add(31);
		
		List<Integer> l4_p = new ArrayList<>();
		l4_p.add(4);
		l4_p.add(41);
		l4_p.add(47);
		l4_p.add(5);
		
		//List game 5
		List<Integer> l5_g = new ArrayList<>();
		l5_g.add(5);
		l5_g.add(12);
		
		List<Integer> l5_p = new ArrayList<>();
		l5_p.add(48);
		
		//List game 6
		List<Integer> l6_g = new ArrayList<>();
		l6_g.add(8);
		l6_g.add(31);
		
		List<Integer> l6_p = new ArrayList<>();
		l6_p.add(6);
		l6_p.add(9);
		l6_p.add(12);
		
		//List game 7
		List<Integer> l7_g = new ArrayList<>();
		l7_g.add(12);
		l7_g.add(14);
				
		List<Integer> l7_p = new ArrayList<>();
		l7_p.add(8);
		
		//List game 8
		List<Integer> l8_g = new ArrayList<>();
		l8_g.add(5);
				
		List<Integer> l8_p = new ArrayList<>();
		l8_p.add(6);
		l8_p.add(14);
		l8_p.add(42);
		
		//List game 9
		List<Integer> l9_g = new ArrayList<>();
		l9_g.add(5);
		l9_g.add(10);
		l9_g.add(14);
		l9_g.add(31);
				
		List<Integer> l9_p = new ArrayList<>();
		l9_p.add(6);
		l9_p.add(9);
		l9_p.add(48);
		l9_p.add(12);
		l9_p.add(49);
		
		//List game 10
		List<Integer> l10_g = new ArrayList<>();
		l10_g.add(2);
		l10_g.add(32);
				
		List<Integer> l10_p = new ArrayList<>();
		l10_p.add(34);
		l10_p.add(39);

		//Create games
		Game g1 = new Game();
		g1.setId(11208);
		g1.setName("NieR: Automata");
		g1.setGenres(l1_g);
		g1.setPlatforms(l1_p);
		addGame(g1);
		
		Game g2 = new Game();
		g2.setId(12070);
		g2.setName("Party Hard");
		g2.setGenres(l2_g);
		g2.setPlatforms(l2_p);
		addGame(g2);
		
		Game g3 = new Game();
		g3.setId(1397);
		g3.setName("Professor Layton and the Curious Village");
		g3.setGenres(l3_g);
		g3.setPlatforms(l3_p);
		addGame(g3);
		
		Game g4 = new Game();
		g4.setId(1074);
		g4.setName("Super Mario 64");
		g4.setGenres(l4_g);
		g4.setPlatforms(l4_p);
		addGame(g4);
		
		Game g5 = new Game();
		g5.setId(11156);
		g5.setName("Horizon: Zero Dawn");
		g5.setGenres(l5_g);
		g5.setPlatforms(l5_p);
		addGame(g5);
				
		Game g6 = new Game();
		g6.setId(128);
		g6.setName("Assassin's Creed");
		g6.setGenres(l6_g);
		g6.setPlatforms(l6_p);
		addGame(g6);
		
		Game g7 = new Game();
		g7.setId(1219);
		g7.setName("Kingdom Hearts");
		g7.setGenres(l7_g);
		g7.setPlatforms(l7_p);
		addGame(g7);

		Game g8 = new Game();
		g8.setId(621);
		g8.setName("Call of Duty");
		g8.setGenres(l8_g);
		g8.setPlatforms(l8_p);
		addGame(g8);

		Game g9 = new Game();
		g9.setId(1020);
		g9.setName("Grand Theft Auto V");
		g9.setGenres(l9_g);
		g9.setPlatforms(l9_p);
		addGame(g9);
		
		Game g10 = new Game();
		g10.setId(15699);
		g10.setName("Neko Atsume: Kitty Collector");
		g10.setGenres(l10_g);
		g10.setPlatforms(l10_p);
		addGame(g10);
		
	}
	
	public Collection<Game> getAllGames() {
		return gameMap.values();
	}
	
	public Game getGame(Integer id) {
		return gameMap.get(id);
	}
	
	public void addGame(Game g) {
		Integer id = index++;	
		g.setId(id);
		gameMap.put(id, g);
	} 
	
	public void updateGame(Game g) {
		gameMap.put(g.getId(), g);
	}
	
	public void deleteGame(Integer id) {	
		gameMap.remove(id);
	}	
}