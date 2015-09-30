package com.cmad.database;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


@ApplicationPath("/services")
public class RestApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> empty = new HashSet<Class<?>>();
	public RestApplication() {
		singletons.add(new PostResource());
		singletons.add(new CommentResource());
		singletons.add(new UserResource());
	}
	public Set<Class<?>> getClasses() {
		return empty;
	}
	public Set<Object> getSingletons() {
		return singletons;
	}	
}