package io.javabrains.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	//handle specific exceptions
	@ExceptionHandler(ResourceNotFoundExcepetion.class)
	public ResponseEntity<?> handleResourseNotFoundException(ResourceNotFoundExcepetion exception ,WebRequest request){
		ErroDetails errorDetails=new ErroDetails(new Date(),exception.getMessage(),request.getDescription(false));
		
		return new ResponseEntity(errorDetails ,HttpStatus.NOT_FOUND);
	}
	//handle global exceptions
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGlobalException(Exception exception ,WebRequest request){
		ErroDetails errorDetails=new ErroDetails(new Date(),exception.getMessage(),request.getDescription(false));
		
		return new ResponseEntity(errorDetails ,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	//handle custom validation exceptions
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> customValidationErrorHandling(MethodArgumentNotValidException exception ,WebRequest request){
		ErroDetails errorDetails=new ErroDetails(new Date(),"validation error",exception.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity(errorDetails ,HttpStatus.BAD_REQUEST);
	}

}
