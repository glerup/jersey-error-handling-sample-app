package org.example.errorhandling;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Variant;

import org.example.errorhandling.repr.Error;
import org.example.errorhandling.repr.Greeting;

@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Path("/{name}")
public class Greeter {
	private final String name;

	public Greeter(@PathParam("name") String name, @Context Request request) {
		if ("Vader".equals(name)) {
			Error error = new Error();
			error.message = "Illegal name";
			List<Variant> variants = Variant.mediaTypes(MediaType.APPLICATION_JSON_TYPE, MediaType.APPLICATION_XML_TYPE).add().build();
			Variant variant = request.selectVariant(variants);
			Response errorResponse = Response.status(Status.BAD_REQUEST).entity(error).variant(variant).build();
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
