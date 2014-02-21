package org.example.errorhandling;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

public class GreeterApplication extends Application {
	@Override
	public Set<Class<?>> getClasses() {
		HashSet<Class<?>> classes = new HashSet<>();
		classes.add(Greeter.class);
		classes.add(GreeterInitializationExceptionMapper.class);
		classes.add(JacksonJsonProvider.class);
		return classes;
	}
}
