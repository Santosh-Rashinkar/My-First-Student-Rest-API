package com.prowings.exception;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.prowings.model.MyCustomError;

public class StudentExceptionHandler {
	
	@ExceptionHandler(SQLException.class)
	public ResponseEntity<String> handleSQLException(HttpServletRequest request, Exception ex){
		System.out.println("inside SQLEx handler method");
		return new ResponseEntity<String>("database_error", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<MyCustomError> handleStudentNotFoundException(HttpServletRequest request, Exception ex){
		
		System.out.println("inside StudentNotFoundException handler method");
		MyCustomError error = new MyCustomError();
		error.setMessage(ex.getMessage());
		error.setRootCause("abc");
		error.setStatusCode(404);
		
		return new ResponseEntity<MyCustomError>(error, HttpStatus.NOT_FOUND);

	}
	@ExceptionHandler(InvalidStudentException.class)
	public ResponseEntity<MyCustomError> handleInvalidStudentException(HttpServletRequest request, Exception ex){
		
		System.out.println("inside handleInvalidStudentException handler method");
		MyCustomError error = new MyCustomError();
		error.setMessage(ex.getMessage());
		error.setRootCause("abc");
		error.setStatusCode(400);
		
		return new ResponseEntity<MyCustomError>(error, HttpStatus.BAD_REQUEST);
		
	}
}