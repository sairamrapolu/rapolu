
package com.massiltech.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class MyPainManagerGlobalException {

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ExceptionResponse hadlePatientnotFoundException(ResourceNotFoundException exception,
			HttpServletRequest request) {
		ExceptionResponse response = new ExceptionResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage(),
				request.getRequestURI());
		return response;
	}

}
