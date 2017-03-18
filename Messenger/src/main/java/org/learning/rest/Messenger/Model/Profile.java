package org.learning.rest.Messenger.Model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
	
@XmlRootElement
public class Profile {

	private String firstName;
	private String lastName;
	private String profileName;
	private Date created;
	
	
	
	public Profile() {
	
	}
	public Profile(String firstName, String lastName, String profileName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.profileName = profileName;
	
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
	
}
