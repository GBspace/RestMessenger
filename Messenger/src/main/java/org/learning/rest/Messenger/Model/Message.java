package org.learning.rest.Messenger.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Message {
	private long id;
	private String message;
	private Date createdOn;
	private String author;
	private Map<Long,Comment> comments = new HashMap<>();
	private List<Link> links = new ArrayList<>();
	
	public Message() {
		
	}
	public Message(long id, String message, String author) {
		
		this.id = id;
		this.message = message;
		this.createdOn = new Date();
		this.author = author;
	}
	@XmlTransient   // to ignore when message instance is converted to xml/json
	public Map<Long, Comment> getComments() {
		return comments;
	}
	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public List<Link> getLinks() {
		return links;
	}
	public void setLinks(List<Link> links) {
		this.links = links;
	}

	public void addLink(String url,String rel){
		Link link = new Link();
		link.setLink(url);
		link.setRel(rel);
		links.add(link);
	}

}
