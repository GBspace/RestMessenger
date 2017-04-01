package org.learning.rest.Messenger.Exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.learning.rest.Messenger.Model.ErrorMessage;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable arg0) {
		ErrorMessage errMsg = new ErrorMessage(arg0.getMessage(),500,"https://ghummakads.wordpress.com/");
		
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errMsg).build();
	}

}
