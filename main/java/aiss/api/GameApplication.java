package aiss.api;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import aiss.resources.GameResource;
import aiss.resources.IGDBResource;

public class GameApplication extends Application{
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();

	public GameApplication() {

		singletons.add(GameResource.getInstance());
		singletons.add(IGDBResource.getInstance());
	}

	public Set<Class<?>> getClasses() {
		return classes;
	}

	public Set<Object> getSingletons() {
		return singletons;
	}
}