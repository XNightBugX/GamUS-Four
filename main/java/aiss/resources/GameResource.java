package aiss.resources;

import java.net.URI;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.model.igdb.Game;
import aiss.repository.GameRepository;
import aiss.repository.MapGameRepository;

@Path("/games")
public class GameResource {
	
	public static GameResource _instance=null;
	GameRepository repository;

	private GameResource(){
		repository=MapGameRepository.getInstance();
	}
	
	public static GameResource getInstance() {
		if(_instance==null) {
			_instance=new GameResource();
		}
		return _instance; 
	}
	
	@GET
	@Produces("application/json")
	public Collection<Game> getAll() {
		return repository.getAllGames();
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Game get(@PathParam("id") Integer id) {
		return repository.getGame(id);
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addGame(@Context UriInfo uriInfo, Game game) {
		if(game.getName() == null || "".equals(game.getName())) {
			throw new BadRequestException("The name of the game must not be null");
		}else if(game.getGenres() == null || "".equals(game.getGenres())) {
			throw new BadRequestException("The list of genres must not be null");
		} else if(game.getPlatforms() == null || "".equals(game.getPlatforms())) {
			throw new BadRequestException("The list of platforms must not be null");
		}
		
		repository.addGame(game);
		
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(game.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(game);			
		return resp.build();
	}
	
	@PUT
	@Consumes("application/json")
	public Response updateGame(Game game) {
		if(repository.getGame(game.getId()) == null) {
			throw new NotFoundException("The game with id = "+ game.getId() +" was not found");
		}
		
		Game g = repository.getGame(game.getId());
		if(game.getName() != null) {
			g.setName(game.getName() );
		}
		if(game.getGenres() != null) {
			g.setGenres(game.getGenres());
		}
		if(game.getPlatforms() != null) {
			g.setPlatforms(game.getPlatforms());
		}
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteGame(@PathParam("id") Integer gameId) {
		if(repository.getGame(gameId) == null) {
			throw new NotFoundException("The game with id = "+ gameId +" was not found");
		}
		repository.deleteGame(gameId);
		return Response.noContent().build();
	}	
}