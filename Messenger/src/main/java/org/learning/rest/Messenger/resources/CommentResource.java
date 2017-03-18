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
import org.learning.rest.Messenger.service.CommentService;
import org.learning.rest.Messenger.Model.Comment;

@Path("/")   // No path value, as path is fetched from messageResource
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {

	private CommentService commentService = new CommentService();
	
	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long messageId){
		return commentService.getAllComments(messageId);
	}
	
	@GET
	@Path("/{commentId}")
	public Comment getCommentById(@PathParam("commentId") long commentId,
								 @PathParam("messageId") long messageId){
		return commentService.getComment(messageId, commentId);
	}
	
	@POST
	public Comment addComment(@PathParam("messageId") long messageId, Comment comment){
		return commentService.addComment(messageId, comment);
	}
	
	@PUT
	@Path("/{commentId}")
	public Comment updateComment(@PathParam("commentId") long commentId,
			 					 @PathParam("messageId") long messageId, Comment comment){
		comment.setId(commentId);
		return commentService.udpateComment(messageId, comment);
	}
	
	@DELETE
	@Path("/{commentId}")
	public void deleteComment(@PathParam("commentId") long commentId,
			 				  @PathParam("messageId") long messageId){
		commentService.removeComment(messageId, commentId);
	}
}
