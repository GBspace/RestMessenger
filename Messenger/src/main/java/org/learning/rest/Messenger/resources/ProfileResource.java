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
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

import org.learning.rest.Messenger.Model.Profile;
import org.learning.rest.Messenger.service.ProfileService;


@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {

	private ProfileService profService = new ProfileService();
	
	@GET
	public List<Profile> getAllProfiles(){
		return profService.getAllProfiles();
	}
	
	@POST
	public Profile addProfile(Profile profile){
		return profService.addProfile(profile);
	}
	
	@Path("/{profileName}")
	@PUT
	public Profile updateProfile(@PathParam("profileName") String name, Profile profile){
		profile.setProfileName(name);
		return profService.updateProfile(profile);
	}
	
	@Path("/{profileName}")
	@DELETE
	public void deleteProfile(@PathParam("profileName") String name){
		profService.removeProfile(name);
	}
}
