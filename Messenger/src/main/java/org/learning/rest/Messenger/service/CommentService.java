package org.learning.rest.Messenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Singleton;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.learning.rest.Messenger.Model.Comment;
import org.learning.rest.Messenger.Model.ErrorMessage;
import org.learning.rest.Messenger.Model.Message;
import org.learning.rest.Messenger.database.databaseClass;

@Singleton
public class CommentService {
	private Map<Long,Message> messages = databaseClass.getMessageMap();
	
	public List<Comment> getAllComments(long messageId){
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());
	}
	
	public Comment getComment(Long messageId, Long commentId){
		ErrorMessage errMsg = new ErrorMessage("Not Found", 404, "https://ghummakads.wordpress.com/");
		Response resp = Response.status(Status.NOT_FOUND).entity(errMsg).build();
		Message msg = messages.get(messageId);
		if(msg == null){
			throw new WebApplicationException(resp);
		}
		
		Map<Long, Comment> comments = msg.getComments();
		Comment com = comments.get(commentId);
		if(com == null){
			throw new NotFoundException(resp);
		}
		return com;
	}
	
	public Comment addComment(long messageId, Comment comment){
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size()+1);
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment udpateComment(long messageId, Comment comment){
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if(comment.getId() <= 0){
			return null;
		}
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public void removeComment(long messageId, long commentId){
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comments.remove(commentId);
	}

}
