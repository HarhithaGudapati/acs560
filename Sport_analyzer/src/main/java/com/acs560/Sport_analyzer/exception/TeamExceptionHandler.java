/*	package com.acs560.Sport_analyzer.exception;
	
	import org.springframework.core.annotation.Order;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.ExceptionHandler;
	import org.springframework.web.bind.annotation.RestControllerAdvice;
	
	import java.util.NoSuchElementException;
	
	import org.springframework.core.Ordered;
	
	@RestControllerAdvice
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public class TeamExceptionHandler {
	
	    @ExceptionHandler(NoSuchElementException.class)
	    public ResponseEntity<String> handleNoSuchElementException() {
	        return ResponseEntity.badRequest().body("No match found");
	    }
	}
*/



// Exception handler class

package com.acs560.Sport_analyzer.exception;

import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

import org.springframework.core.Ordered;

/**
 * The sport analyzer common exception handler
 */
@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class TeamExceptionHandler {

    /**
     * Handler for NoSuchElementException
     * @return Response entity
     */
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException ex) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        ex.printStackTrace();
        return ResponseEntity.internalServerError().body("We're sorry...but we failed :(");
    }
}
