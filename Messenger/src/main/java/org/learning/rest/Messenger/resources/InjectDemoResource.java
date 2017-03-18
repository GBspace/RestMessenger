package org.learning.rest.Messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)

public class InjectDemoResource {
	@GET
	@Path("annotations")   //Matrix Param passed with semicolon
	public String getParamUsingAnnotation(@MatrixParam("param") String MatrixParam,
										  @HeaderParam("headerParam") String customHeader,
										  @CookieParam("name") String cookie){   
											/* One more param is left and i.e. FormParam*/
		return ("header param: "+ customHeader + " , matrix param: " + MatrixParam + " , Cookie:" + cookie);	    
		//header param is used to create your own header/authentication session 
	}
	
	
}
