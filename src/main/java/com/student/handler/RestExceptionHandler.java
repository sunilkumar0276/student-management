package com.student.handler;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler
{
	@ExceptionHandler({RecordNotFoundException.class,RecordExistsException.class})
	protected ResponseEntity<Object> handleRecordNotFoundException(final BaseException exe)
	{
		final ApiResponseBody apiError = new ApiResponseBody(exe.getHttpStatuCode(), false);
		apiError.setMessage(exe.getMessage());
		return buildResponseEntity(apiError);
	}

	private ResponseEntity<Object> buildResponseEntity(final ApiResponseBody apiError)
	{
		return new ResponseEntity<>(apiError, apiError.getStatus());
	} 

}
