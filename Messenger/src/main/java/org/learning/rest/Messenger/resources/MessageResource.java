package org.learning.rest.Messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.learning.rest.Messenger.Model.Message;
import org.learning.rest.Messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	MessageService msgService = new MessageService();
	
	@GET
	public List<Message> getMessages(@QueryParam("year") int year, 
									 @QueryParam("start") int start,	
									 @QueryParam("size") int size){
		if(year > 0 ){
			return msgService.getAllMessagesForYear(year);
		}
		
		if(start >= 0 && size > 0){
			return msgService.getAllMessagesPaginated(start, size);
		}
		
		return msgService.getAllMessages();
			
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessageBasedOnID(@PathParam("messageId") long messageId){
		return msgService.getMessage(messageId);
	}
	
	@POST
	public Message postMessage(Message message){
		return msgService.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long id, Message message){
		message.setId(id);
//		System.out.println("Before Updating" + msgService.getAllMessages());
		return msgService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long id){
		msgService.removeMessage(id);
	}
	
}
