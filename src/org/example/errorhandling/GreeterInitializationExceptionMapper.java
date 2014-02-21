package org.example.errorhandling;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.example.errorhandling.repr.Error;

@Provider
public class GreeterInitializationExceptionMapper implements ExceptionMapper<GreeterInitializationException> {
	@Override
	public Response toResponse(GreeterInitializationException arg0) {
		Error error = new Error();
		error.message = "Illegal name";
		Response errorResponse = Response.status(Status.BAD_REQUEST).entity(error).build();
		return errorResponse;
	}
}
