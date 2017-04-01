package org.learning.rest.Messenger.Exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.learning.rest.Messenger.Model.ErrorMessage;



@Provider   //register this class to jax rs
public class DataNotFoundExcecptionMapper implements ExceptionMapper<DataNotFoundException>{

	@Override
	public Response toResponse(DataNotFoundException exception) {
		ErrorMessage errMsg = new ErrorMessage(exception.getMessage(), 404, "https://ghummakads.wordpress.com/");
		return Response.status(Status.NOT_FOUND).entity(errMsg).build();
	}

}
