package org.learning.rest.Messenger.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.inject.Singleton;

import org.learning.rest.Messenger.Model.Message;
import org.learning.rest.Messenger.Model.Profile;
import org.learning.rest.Messenger.database.databaseClass;

@Singleton
public class ProfileService {
	
	private static Map<String,Profile> profiles =  databaseClass.getProfileMap();
	
	public ProfileService() {
		profiles.put("Garima", new Profile("Garima", "Jain", "garimjai"));
		profiles.put("Gaurav", new Profile("Gaurav", "Jain", "gaujai"));
	}

	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String name){
		return profiles.get(name);
	}
	
	public Profile addProfile(Profile profile){
//		profiles.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
		if(profile.getProfileName().isEmpty()){
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName){
		return profiles.remove(profileName);
	}
	
	
	
}
