package com.accessstop.common.exception;

import java.text.MessageFormat;

public class ConflictException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ConflictException(String message) {
		super(message);
	}
	
	public ConflictException(String message, Object... args) {
		super(MessageFormat.format(message, args));
	}

}
