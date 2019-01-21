package com.accessstop.common.exception;

import java.text.MessageFormat;

public class PreconditionFailedException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public PreconditionFailedException(String message) {
		super(message);
	}
	
	public PreconditionFailedException(String message, Object... args) {
		super(MessageFormat.format(message, args));
	}

}
