package org.learning.rest.Messenger.resources.beans;

import javax.ws.rs.QueryParam;

//Move all the queryParam to this class
public class MessageFilterBean {
	private @QueryParam("year") int year;
	 private @QueryParam("start") int start;	
	 
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	private @QueryParam("size") int size;
}
