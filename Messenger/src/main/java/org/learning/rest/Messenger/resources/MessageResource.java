package org.learning.rest.Messenger.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
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
import org.learning.rest.Messenger.resources.beans.MessageFilterBean;
import org.learning.rest.Messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	MessageService msgService = new MessageService();
	
	@GET
	public List<Message> getMessages(@BeanParam MessageFilterBean filterBean){
		if(filterBean.getYear() > 0 ){
			return msgService.getAllMessagesForYear(filterBean.getYear());
		}
		
		if(filterBean.getStart() >= 0 && filterBean.getSize() > 0){
			return msgService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getStart());
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
	
	//@GET   //Not the ideal way of doing it, as this class should also deal with Message,
		   //so implement a sub resource that will delegate the work to some other resource
		   //remvover GET as any request to this pattern should get redirected not just GET
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource(){
		return new CommentResource();
	}
	
}
