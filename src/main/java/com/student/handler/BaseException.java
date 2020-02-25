package com.student.handler;

import org.springframework.http.HttpStatus;

public abstract class BaseException extends Exception
{
	private static final long serialVersionUID = 8579648815126192065L;
	
	public BaseException(String msg)
	{
		super(msg);
	}

	public abstract HttpStatus getHttpStatuCode();
}