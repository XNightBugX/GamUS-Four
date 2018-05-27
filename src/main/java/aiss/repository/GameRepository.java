package aiss.repository;

import java.util.Collection;

import aiss.model.igdb.Game;

public interface GameRepository {
	public Collection<Game> getAllGames();
	public Game getGame(Integer gameId);
	public void addGame(Game s);
	public void updateGame(Game s);
	public void deleteGame(Integer gameId);
}