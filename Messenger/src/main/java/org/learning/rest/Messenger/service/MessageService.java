package org.learning.rest.Messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.inject.Singleton;

import org.learning.rest.Messenger.Exception.DataNotFoundException;
import org.learning.rest.Messenger.Model.Message;
import org.learning.rest.Messenger.database.databaseClass;

@Singleton
public class MessageService {
	
	private static Map<Long,Message> messages =  databaseClass.getMessageMap();
	
	public MessageService() {
		
		messages.put(1L, new Message(1, "Time to sleep", "garimjai"));
		messages.put(2L, new Message(2, "Good Night", "gb"));
		messages.put(3L, new Message(3, "Sleep tight", "garima jain"));
	}

	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
    public List<Message> getAllMessagesForYear(int year){
    	List<Message> listMsg = new ArrayList<>();
    	Calendar cal = Calendar.getInstance();
    	for(Message msg : messages.values()){
    		cal.setTime(msg.getCreatedOn());
    		if(cal.get(Calendar.YEAR) == year){
    			listMsg.add(msg);
    		}
    	}
    	return listMsg;
    }
    
    public List<Message> getAllMessagesPaginated(int start, int size){
    	ArrayList<Message> listMsg = new ArrayList<Message>(messages.values()); 
    	return listMsg.subList(start, start+size);	
    }
	
	public Message getMessage(Long id){
		Message newMessage = messages.get(id);
		if (newMessage == null){
			throw new DataNotFoundException("Message with ID " + id + "not found");
		}
		return newMessage;
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message){
		if(message.getId() <= 0){
			return null;
		}
		messages.put(message.getId(), message);
//		System.out.println("After update" + messages.values());
		return message;
	}
	
	public Message removeMessage(Long id){
		return messages.remove(id);
	}
	
	
	
}
