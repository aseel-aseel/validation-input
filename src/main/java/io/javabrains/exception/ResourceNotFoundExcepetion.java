package io.javabrains.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundExcepetion extends RuntimeException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	public ResourceNotFoundExcepetion(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
}
