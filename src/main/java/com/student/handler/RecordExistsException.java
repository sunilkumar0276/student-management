package com.student.handler;

import org.springframework.http.HttpStatus;


public class RecordExistsException extends BaseException
{
	private static final long serialVersionUID = -2110459246287723869L;

	public RecordExistsException(final String msg)
	{
		super( msg);
	}

	@Override
	public HttpStatus getHttpStatuCode() {
		return HttpStatus.CONFLICT;
	} 
}
