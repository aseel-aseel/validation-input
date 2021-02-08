package io.javabrains.exception;

import java.util.Date;

public class ErroDetails {

	
	private Date timeStampe;
	private String message;
	private String Details;
	
	
	
	
	

	public ErroDetails(Date timeStampe, String message, String details) {
		super();
		this.timeStampe = timeStampe;
		this.message = message;
		Details = details;
	}
	public Date getTimeStampe() {
		return timeStampe;
	}
	public void setTimeStampe(Date timeStampe) {
		this.timeStampe = timeStampe;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return Details;
	}
	public void setDetails(String details) {
		Details = details;
	}
	public ErroDetails() {
		super();
	}
	
}
