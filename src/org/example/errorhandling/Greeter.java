package org.example.errorhandling;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.example.errorhandling.repr.Error;
import org.example.errorhandling.repr.Greeting;

@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Path("/{name}")
public class Greeter {
	private final String name;

	public Greeter(@PathParam("name") String name) {
		if ("Vader".equals(name)) {
			Error error = new Error();
			error.message = "Illegal name";
			Response errorResponse = Response.status(Status.BAD_REQUEST).entity(error).build();
			throw new WebApplicationException(errorResponse);
		} else {
			this.name = name;
		}
	}

	@GET
	public Response greet() {
		Greeting greeting = new Greeting();
		greeting.text = "Hello, " + name;
		return Response.ok(greeting).build();
	}
}
