package org.learning.rest.Messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.learning.rest.Messenger.Model.Message;
import org.learning.rest.Messenger.Model.Profile;

public class databaseClass {
	private static Map<Long,Message>  messageMap = new HashMap<>();
	private static Map<String, Profile> profileMap = new HashMap<>();
	
	public static Map<Long, Message> getMessageMap() {
		return messageMap;
	}
	public static Map<String, Profile> getProfileMap() {
		return profileMap;
	}
	
	
}
