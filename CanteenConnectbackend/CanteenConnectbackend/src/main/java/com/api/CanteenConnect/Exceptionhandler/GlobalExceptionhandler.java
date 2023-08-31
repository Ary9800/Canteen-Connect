package com.api.CanteenConnect.Exceptionhandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.api.CanteenConnect.Dto.ErrorResponse;


@RestControllerAdvice
public class GlobalExceptionhandler  {
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> catchAllException(RuntimeException e) {
		e.printStackTrace();
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(e.getLocalizedMessage());
		errorResponse.setTimestamp(LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}

	// exception handler for all the exception occured in the pojo validtion
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		// convert List<FieldError> --> Map: fieldName , def mesg
//		Map<String, String> map=e.getFieldErrors() //List<FieldErr>
//				.stream() //Stream<FieldError>
//				.collect(Collectors.toMap(f -> f.getField(), 
//						f -> f.getDefaultMessage()));
//		
		Map<String, String> map = new HashMap<>();
		for (FieldError f : ex.getFieldErrors())
			map.put(f.getField(), f.getDefaultMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);}
		// List<FieldError> getFieldErrors()
		
}
